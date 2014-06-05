package shop;
import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PizzaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<PizzaData> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + PizzaData.class.getName();
            try {
                list = (List<PizzaData>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                PizzaData data = (PizzaData)manager.getObjectById(PizzaData.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(PizzaData data:list){
                res += "{id:" + data.getId() + ",address:'" + data.getAddress() + "',name:'" +
                    data.getName() + "',date:'" + data.getDatetime() +
                    "',tell:'" + data.getTell() +"',pizza:'" + data.getPizza() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
	
}
