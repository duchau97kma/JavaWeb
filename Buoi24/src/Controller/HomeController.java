package Controller;
import DTO.LoginForm;
import DTO.Member;
import DTO.RegisterForm;
import Model.MemberModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("name")
public class HomeController {
    @RequestMapping("/")
    public String helloWorld(){
        return "index";
    }
    @RequestMapping("/add-product")
    public String addProduct(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        if(name !=null){
            return "AddProduct";
        }else{
            LoginForm form = new LoginForm();
            model.addAttribute("login",form);
            return "/Login";
        }
    }
    @RequestMapping("/Register")
    public String register(Model model){
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("register",registerForm);
        return "Register";
    }
    @RequestMapping("authR")
    public String authR(@ModelAttribute("register") RegisterForm registerForm, Model model){
    try {
        MemberModel memberModel = new MemberModel();
        if(memberModel.checkRegister(registerForm.getEmail())==false){
        String name = registerForm.getName();
        String email = registerForm.getEmail();
        String password = registerForm.getPassword();
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        memberModel.addMember(member);
        model.addAttribute("ok","Register successful!");
        }else{
            model.addAttribute("err","Register fail please check again!");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return "Register";
    }
    @RequestMapping("/Login")
    public String login(Model model){
        LoginForm form = new LoginForm();
        model.addAttribute("login",form);
        return "Login";
    }
    @RequestMapping("/auth")
    public String auth(@ModelAttribute("login") LoginForm form,Model model){
        try {
            MemberModel memberModel = new MemberModel();
            Member member = memberModel.checkLogin(form.getEmail(),form.getPassword());
          if(member!=null){
                model.addAttribute("name",member.getName());
              return "index";
          }else {
              model.addAttribute("err","Login fail please check again!");
          }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Login";
    }
    @RequestMapping("/logout")
    public String logout(Model model,SessionStatus status){
        status.setComplete();
        LoginForm form = new LoginForm();
        model.addAttribute("login",form);
        return "/Login";
    }
}
