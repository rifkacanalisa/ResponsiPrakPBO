package Utama;
import controller_pack.Controller;
import view_pack.*;
import controller_pack.*;

public class MVC {
    public MVC(){
        vLogin vLogin = new vLogin();
        Model model = new Model();
        Controller controller = new Controller(vLogin,model);
    }
}
