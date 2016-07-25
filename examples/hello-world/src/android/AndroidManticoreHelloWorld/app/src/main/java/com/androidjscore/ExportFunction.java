package com.androidjscore;

import android.util.Log;
import org.liquidplayer.webkit.javascriptcore.JSContext;
import org.liquidplayer.webkit.javascriptcore.JSObject;

/**
 * Created by nsypteras on 5/13/16.
 */
public class ExportFunction extends JSObject implements ExposedExport
{
  public ExportFunction(JSContext ctx)
  {
    super(ctx, ExposedExport.class);
  }

  @Override
  public void export(JSObject object)
  {
    if (object == null)
    {
      return;
    }

    Log.d("ExportFunction", "manticore.export fired from javascript");

    if (true)
    {
      for (String name : object.propertyNames())
      {
        JSObj.getExportedItems().property(name, object.property(name));
      }
      return;
    }

    if (object.isString())
    {
//      JSObj.getExportedItems().pro
    }
    else if (object.isBoolean())
    {

    }
    else if (object.isFunction())
    {

    }
    else if (object.isNumber())
    {

    }
    else if (object.isObject())
    {

    }
    else if (object.isUndefined())
    {

    }
//    JSObj.getExportedItems().property()
  }
}
