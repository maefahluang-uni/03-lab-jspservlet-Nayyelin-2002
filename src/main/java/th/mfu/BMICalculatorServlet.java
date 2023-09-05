package th.mfu;

import java.io.IOException;

import javax.swing.event.InternalFrameEvent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String w = request.getParameter("weight");
        String h = request.getParameter("height");
        //TODO: calculate bmi
            double weight = Double.parseDouble(w);
            double height = Double.parseDouble(h);
            //BMI
            int bmi = (int)Math.round(weight/(height*height));
         //TODO: determine the built from BMI
            String built;
        if(bmi<18.5){
         built = " Underweight";
        }else if(bmi>= 18.5 && bmi<25){
            built= "normal";
        }else if(bmi<=25 && bmi<30){
            built = "overweight";
        }else if(bmi>=30 && bmi<35){
           built =  "obese";
        }else{
            built = "extermely obese";
        };
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi",bmi);
        request.setAttribute("built",built);
        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
    }
           
};


