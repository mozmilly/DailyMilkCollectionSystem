/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/**
 *
 * @author enrico
 */
import beans.AccountInfoBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class PathFilter implements Filter {

    List<String> adminUrls = Arrays.asList("/DailyMilkCollectionSystem/account",
            "/DailyMilkCollectionSystem/create-tender", "/DailyMilkCollectionSystem/add-supplier",
            "/DailyMilkCollectionSystem/logout", "/DailyMilkCollectionSystem/tender-document",
            "/DailyMilkCollectionSystem/tender-details");
    List<String> collectorUrls = Arrays.asList("/DailyMilkCollectionSystem/account",
            "/DailyMilkCollectionSystem/supply", "/DailyMilkCollectionSystem/logout");
    List<String> anonymousUsersUrls = Arrays.asList("/DailyMilkCollectionSystem/",
            "/DailyMilkCollectionSystem/Contactus.jsp", "/DailyMilkCollectionSystem/login");
    List<String> filesUrls = Arrays.asList("/DailyMilkCollectionSystem/css/", 
            "/DailyMilkCollectionSystem/js/", "/DailyMilkCollectionSystem/img/", 
            "/DailyMilkCollectionSystem/font/");

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse resp = (HttpServletResponse) sr1;
        HttpSession session = req.getSession();
        //get url
        String url = req.getRequestURI();
        System.out.println("URL: " + url);
        if (session.getAttribute("loggedIn") != null) {
            if ((Boolean) session.getAttribute("loggedIn")) {
                //loggedin users
                //get user's role
                AccountInfoBean accountInfo = (AccountInfoBean) session.getAttribute("accountInfo");
                String role = accountInfo.getRole();
                if (role.equals("ADMIN")) {
                    if (!adminUrls.contains(url) && !anonymousUsersUrls.contains(url) && !isFilePath(url)) {
                        req.getRequestDispatcher("/logout").forward(req, sr1);
                    } else {
                        fc.doFilter(req, sr1);
                    }
                } else if (role.equals("COLLECTOR")) {
                    if (!collectorUrls.contains(url) && !anonymousUsersUrls.contains(url) && !isFilePath(url)) {
                        req.getRequestDispatcher("/logout").forward(req, sr1);
                    } else {
                        fc.doFilter(req, sr1);
                    }
                } else {
                    if (!anonymousUsersUrls.contains(url) && !isFilePath(url)) {
                        resp.sendRedirect("/logout");
                    } else {
                        fc.doFilter(req, sr1);
                    }
                }
            }
        } else {
            //anonymous users
            System.out.println("IS FILE PATH: " + isFilePath(url));
            if (!anonymousUsersUrls.contains(url) && !isFilePath(url)) {
                resp.sendRedirect("/DailyMilkCollectionSystem/");
            } else {
                fc.doFilter(req, sr1);
            }
        }
    }
    
    private boolean isFilePath(String url){
        for(String s: filesUrls){
            if(url.startsWith(s)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
    }

}
