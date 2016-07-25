package com.androidjscore;

import org.liquidplayer.webkit.javascriptcore.JSContext;
import org.liquidplayer.webkit.javascriptcore.JSObject;
import org.liquidplayer.webkit.javascriptcore.JSValue;


public class JSObj extends JSObject
{

  protected JSValue instance;
  private static JSObject exportedItems;

  static JSContext engine;


  public static JSContext getEngine()
  {
    return engine;
  }

  public JSObject getJSClass(String name)
  {
    return exportedItems.property(name).toObject();
  }

  public static JSObject getExportedItems()
  {
    return exportedItems;
  }

  public static void createEngine(String string)
  {
    engine = new JSContext();
    exportedItems = new JSObject(engine);
    setUpMethods();
    engine.evaluateScript(string);
  }

  private static void setUpMethods()
  {
    engine.property("manticore", new ExportFunction(engine));
    engine.evaluateScript("construct = function (C,args) { " +
                                    " function F() { return C.apply(this, args); }\n" +
                                    " F.prototype = C.prototype;\n" +
                                    " return new F(); }");

  }

  public Object getJSObjectConverter(JSValue value)
  {
    if (value.isNumber())
      return (int)Math.round(value.toNumber());
    else if (value.isString())
      return value.toString();
    return value;
  }
}
