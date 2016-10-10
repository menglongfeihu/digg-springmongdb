package com.sohu.tv.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.sohu.tv.filter.model.Iplimit;


public class SecurityFilter extends OncePerRequestFilter {
	private static final Log log = LogFactory.getLog(SecurityFilter.class);
	private boolean initialized = false;
	public static HashMap<String,Iplimit> iplimits = null;
	private String excludedFile;
    public void setExcludedFile(String excludedFile) {
        this.excludedFile = excludedFile;
    }

	public void destroy() {
	}

	@SuppressWarnings("rawtypes")
	private synchronized void doInit() throws ServletException {
		if (initialized) {
			return;
		}
		try {
            // 如果配置includeFile存在，则解析
            InputStream infile = null;
            try {
                infile = SecurityFilter.class.getClassLoader().getResourceAsStream(excludedFile);
            } catch (Exception e) {
                log.error("Not found file [ " + excludedFile + " ]!" + "|error=",e);
                initialized = true;
                return;
            }
            
            if (infile != null) {
            	iplimits = new HashMap<String,Iplimit>();
                SAXReader reader = new SAXReader(false);
                Document document = reader.read(infile);
                Element root;
                if(document!=null){
    				root = document.getRootElement();
    				for (Iterator it = root.elementIterator(); it.hasNext();) {  
    					Iplimit iplimit_c = new Iplimit();
    					Element iplimit_e = (Element) it.next(); 
    					String pattern=iplimit_e.element("pattern").getText();
    					log.info("file [ " + excludedFile + " ]! config pattern ="+ pattern);
    					String count=iplimit_e.element("count").getText();
    					log.info("file [ " + excludedFile + " ]! config count ="+ count);
    					String model=iplimit_e.element("model").getText();
    					log.info("file [ " + excludedFile + " ]! config model ="+ model);
    					Long count_i=  Long.MAX_VALUE;
    					try{
    						count_i = Long.parseLong(count);
    					}catch (Exception e) {
    						log.error("file [ " + excludedFile + " ]! config count " + "|error=",e);
    					}
    					iplimit_c.setPattern(pattern);
    					iplimit_c.setCount(count_i);
    					iplimit_c.setModel(model);
    					iplimits.put(pattern+count_i+model,iplimit_c);
    				} 
    			}
            }
        } catch (Exception e) {
            log.error("##can't parse SecurityFilter includedPatter File error=",e);
        }
		initialized = true;
	}

	protected ApplicationContext getContext(FilterConfig filterConfig) {
		return WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig
						.getServletContext());
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		if (!initialized) {
			doInit();
		}

//		String ip = request.getRemoteAddr();
//		String refer = request.getHeader("referer");
//        String realIp = request.getHeader("X-Real-IP");
//        log.error("##doFilter refer=" + refer);
//        
//        
//        if (StringUtils.isNotBlank(realIp)){
//        	try {
//    			if (iplimits != null && iplimits.size() > 0){
//    				String bru = request.getRequestURI() != null ? request.getRequestURI() : "";
//                    Pattern p;
//                    Matcher matcher;
//                    Long res ;
//    				Iterator iplimit = iplimits.entrySet().iterator();
//    	    		while (iplimit.hasNext()) {
//    	    			Map.Entry entry_iplimit = (Map.Entry) iplimit.next();
//    					String iplimit_p = entry_iplimit.getKey().toString();
//    					Long iplimit_c = Long.valueOf(entry_iplimit.getValue().toString());
//    					String key = "#" + realIp + iplimit_p + "#";
//    					// 忽略大小写
//    					p = Pattern.compile(iplimit_p, Pattern.CASE_INSENSITIVE);
//    	                matcher = p.matcher(bru);
//    	                if (matcher.find()) {
//    	                    res = (Long)localCache.get(key);
//    	                    if(res == null || res == 0){
//    	                    	localCache.put(key, 1L);
//    	                    }else{
//    	                    	if(res > iplimit_c){
//    	                    		return;
//    	                    	}else{
//    	                    		localCache.put(key, res + 1);
//    	                    	}
//    	                    }
//    	                  }
//    	    		}   
//                }
//    		} catch (Exception e) {
//    			log.error("##doFilter realIp=" + realIp + "|error=", e);
//    		}
//        }

		chain.doFilter(request, response);
		return;
	}

	public static void main(String[] args) {
		String st = "http://www.djkj.pw/index.php?hm=13088134044&c=1";
		System.out.println(st.contains("/index.php?hm="));
	}
}
