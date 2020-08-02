//NOT USING THIS ANYMORE, MAY COME BACK TO IT LATER

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import java.util.HashMap;
//
//public class SceneSwitch {
//    private HashMap<String, Pane> screenMap = new HashMap<>();
//    private Scene main;
//
//    public SceneSwitch(Scene main) {
//        this.main = main;
//    }
//
//    protected void addScreen(String name, Pane pane){
//        screenMap.put(name, pane);
//    }
//
//    protected void removeScreen(String name){
//        screenMap.remove(name);
//    }
//
//    protected EventHandler<ActionEvent> activate(String name){
//        main.setRoot( screenMap.get(name) );
//        return null;
//    }
//
//}
