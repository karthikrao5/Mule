package teamJankkk.model;
import java.io.*;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.charset.Charset;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * Created by karthik on 11/3/15.
 */
public class GameState implements Serializable{

    public static void saveGame(Game game) {

        try {
//            XStream stream = new XStream(new JsonHierarchicalStreamDriver() {
//                public HierarchicalStreamWriter createWriter(Writer writer) {
//                    return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
//                }
//            });
            XStream stream = new XStream();
            String jsonString = stream.toXML(game);
            System.out.println(jsonString);
            FileOutputStream fos = new FileOutputStream(new File("savegame.xml"));
            fos.write(jsonString.getBytes(Charset.forName("UTF-8")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game loadGame() {
//        Game loadedgame = null;
//        XStream stream = new XStream(new JettisonMappedXmlDriver());
////        stream.setMode(XStream.NO_REFERENCES);
//        FileReader fr = null;
//        String xml = null;
//        try {
//            fr = new FileReader("savegame.xml");
//            xml = fr.toString();
//            System.out.println(xml);
//            loadedgame = (Game) stream.fromXML(fr);
//        } catch (FileNotFoundException e) {
//            e.getMessage();
//        }
        return null;
    }
}
