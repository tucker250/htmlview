// Copyright 2013 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.kobjects.htmlview;

import java.net.URI;
import java.util.Map;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class DefaultRequestHandler implements RequestHandler {

  @Override
  public void openLink(HtmlView htmlView, Element a, URI href) {
    Log.i("HtmlView", "openLink " + href);
    if ("_htmlview".equals(a.getAttributeValue("target"))) {
      htmlView.loadAsync(href, HtmlView.Onload.SHOW_HTML);
    } else {
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.setData(Uri.parse(href.toString()));
      htmlView.getContext().startActivity(intent);
    }
  }

  @Override
  public void submitForm(HtmlView htmlView, Element form, URI uri, boolean post, 
      Map<String, String> formData) {
    Log.i("HtmlView", "submitForm " + uri + " data: " + formData);
  }

  @Override
  public void requestImage(HtmlView htmlView, URI uri) {
    Log.i("HtmlView", "requestImage " + uri);
    htmlView.loadAsync(uri, HtmlView.Onload.ADD_IMAGE);
  }

  @Override
  public void requestStyleSheet(HtmlView htmlView, URI uri) {
    Log.i("HtmlView", "requestStyleSheet " + uri);
    htmlView.loadAsync(uri, HtmlView.Onload.ADD_STYLE_SHEET);
  }

}
