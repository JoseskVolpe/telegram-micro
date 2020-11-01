import java.util.Date;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.io.Connector;

import mtproto.MTProtoConnection;
import mtproto.send.SendPing;
import mtproto.UnencryptedResponse;

import bouncycastle.BigInteger;

public class TelegramMicro extends MIDlet {
  private Form form;
  private Display display;

  public TelegramMicro() {
    super();
  }

  public void startApp() {
    Display display = Display.getDisplay(this);
    Form log = new Form("Telegram Micro");
    log.append("Connecting (this may take a while)...");
    display.setCurrent(log);

    try {
      MTProtoConnection connection = new MTProtoConnection("149.154.175.10");
      System.out.println("SENDING PING");
      (new SendPing(25565)).send(connection);
      System.out.println("WAITING FOR RESPONSE");
      connection.wait_for_response();
      System.out.println("GOT RESPONSE");
      UnencryptedResponse unencrypted_response = UnencryptedResponse.from_tcp_response(connection.message_recieve_thread.dequeue_response());
      //We're getting 404 for some reason...
      if (unencrypted_response == null) {
        System.out.println("RESPONSE WAS ENCRYPTED");
      } else {
        System.out.println("RESPONSE WAS NOT ENCRYPTED");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void pauseApp() {}

  public void destroyApp(boolean unconditional) {
    notifyDestroyed();
  }
}
