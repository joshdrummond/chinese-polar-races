import java.awt.*;
import java.io.*;
import java.util.Vector;
import java.net.URL;
import java.applet.*;

//########################################################################

//# C L A S S    CPRResourceLoader
//########################################################################

/**
 * Allows the loading of an image from a JAR file.
 *
 */
public class CPRResourceLoader
{

public static Image getImage(String name)
{
Image img;
InputStream in;
int len;
byte imagedata[];
  if (name==null)
    return null;
  try
    {
    in = CPRResourceLoader.class.getResourceAsStream(name);
    if (in==null)
      {
      System.out.println("no resource:"+name);
      return null;
      }
    byte b[]=new byte[1024];
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    while (true)
      {
      len=in.read(b);
      if (len<0) break;
      out.write(b,0,len);
      }
    out.close();
    in.close();
    imagedata = out.toByteArray();
    }
  catch (Exception e)
    {
    System.out.println("read exc:"+e);
    return null;
    }
  img = Toolkit.getDefaultToolkit().createImage(imagedata);
  return img;
}

//This is preferred, if you have a GUI
public static Image getImage(String name,Component comp)
{
Image img;
  img = getImage(name);
  if (img==null)
    return null;
  MediaTracker mt = new MediaTracker(comp);
  mt.addImage(img,0);
  try
    { mt.waitForAll(); }
  catch (Exception e)
    {}
  return img;
}


//##This is 1.2 only.   NS hates getResource(), by the way
/*
public static AudioClip getAudioClip(String name)
{
AudioClip clip=null;
  if (name==null)
    return null;
  try
    {
    URL url = ResourceLoader.class.getResource(name);
    if (url==null)
      {
      System.out.println("no resource:"+name);
      return null;
      }
    clip = Applet.newAudioClip(url);
    }
  catch (Exception e)
    {
    System.out.println("audio read of '"+name+"':"+e);
    return null;
    }
  return clip;
}
*/

public static String[] getTextFile(String name)
{
BufferedReader in;
  if (name==null)
    return null;
  try
    {
    in = new BufferedReader(new
InputStreamReader(CPRResourceLoader.class.getResourceAsStream(name)));
    }
  catch (Exception e)
    {
    System.out.println("open exc:"+e);
    return null;
    }
  Vector v = new Vector();
  while (true)
    {
    try
      {
      String s = in.readLine();
      v.addElement(s);
      }
    catch (Exception e)
      {
      break;
      }
    }
  try
    {
    in.close();
    }
  catch (Exception e)
    {
    }
  String buf[] = new String[v.size()];
  for (int i=0;i<v.size();i++)
    buf[i]=(String)v.elementAt(i);
  return buf;
}

}
//########################################################################

//# E N D    O F    F I L E
//########################################################################



