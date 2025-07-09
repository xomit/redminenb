/*
 * Copyright 2012 Anchialas <anchialas@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kenai.redminenb.util.markup;

import org.eclipse.mylyn.wikitext.parser.Attributes;
import org.eclipse.mylyn.wikitext.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.textile.TextileLanguage;

import java.io.StringWriter;
import java.io.Writer;

/**
 * Textile Wiki Markup utility.
 *
 * @author Anchialas <anchialas@gmail.com>
 */
public final class TextileUtil {

    private TextileUtil() {
        // omitted
    }

    public static MarkupParser getTextileMarkupParser() {
        return LazyHolder.SINGLETON;
    }

    public static String convertToHTML(String textile) {
        StringWriter writer = new StringWriter();
        convertToHTML(textile, writer);
        return writer.toString();
    }

    public static void convertToHTML(String textile, Writer writer) {
        HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer) {
            @Override
			public void beginSpan(SpanType type, Attributes attributes) {
                // Work-around java limit for html rendering - map:
                // - <del>XY</del> to <span style='text-decoration: line-through'>XY</span>
                if(type == SpanType.DELETED) {
                    type = SpanType.SPAN;
                    attributes.appendCssStyle("text-decoration: line-through");
                } else if (type == SpanType.INSERTED) {
                    type = SpanType.SPAN;
                    attributes.appendCssStyle("text-decoration: underline;");
                }
                super.beginSpan(type, attributes);
            }

        };
        // avoid the <html> and <body> tags
        builder.setEmitAsDocument(false);

        MarkupParser parser = TextileUtil.getTextileMarkupParser();
        parser.setBuilder(builder);
        parser.parse(textile);
        parser.setBuilder(null);
    }

    private static class LazyHolder {

        private static final MarkupParser SINGLETON = createMarkupParser();

        private static MarkupParser createMarkupParser() {
            MarkupParser markupParser = new MarkupParser();
            markupParser.setMarkupLanguage(new TextileLanguage());
            return markupParser;
        }

		private LazyHolder() {
		}
    }
}
