package shop;
 
import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditLinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String tell = req.getParameter("tell");
        String pizza = req.getParameter("pizza");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        PizzaData data = (PizzaData)manager.getObjectById(PizzaData.class,id);
        data.setName(name);
        data.setAddress(address);
        data.setTell(tell);
        data.setTell(pizza);
        manager.close();
        resp.sendRedirect("/show.html");
    }
}