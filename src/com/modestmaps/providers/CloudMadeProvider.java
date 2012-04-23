package com.modestmaps.providers;

import processing.core.*;
import com.modestmaps.core.*;
import com.modestmaps.geo.*;

public class CloudMadeProvider extends AbstractMapProvider {
  
  public String[] subdomains = new String[] { "", "a.", "b.", "c." };
  String key;
  String style;
  
  public String ORIGINAL = "1";
  public String FINE_LINE = "2";
  public String TOURIST = "7";
  public String FRESH = "997";
  public String PALE_DAWN = "998";
  public String MIDNIGHT_COMMANDER = "999"

  public CloudMadeProvider(String key, String style) {
    this.key = key;
    this.style = style;
    super(new MercatorProjection(26, new Transformation(1.068070779e7f, 0.0f, 3.355443185e7f, 0.0f, -1.068070890e7f, 3.355443057e7f)));
  }

  public int tileWidth() {
    return 256;
  }

  public int tileHeight() {
    return 256;
  }

  public String[] getTileUrls(Coordinate coordinate) {
    String img = this.key + "/" + this.style + "/" + this.tileWidth() + "/" + (int)coordinate.zoom + "/" + (int)coordinate.column + "/" + (int)coordinate.row + ".png";
    String url = "http://" + subdomains[(int)random(0, 4)] + "tile.cloudmade.com/" + img;
    return new String[] { url };
  }

}

