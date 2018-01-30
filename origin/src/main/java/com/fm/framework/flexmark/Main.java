package com.fm.framework.flexmark;

import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.KeepType;
import org.junit.Test;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.io.*;
import java.util.Arrays;

/**
 * @author footmanff on 2017/8/12.
 */
public class Main {

    /**
     * (@value Emplo)
    */

    @Test
    public void t2() {
        while (true) {
            t();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param
     * @implSpec
     * @see
     * @throws
     * @fieldCode good
     */
    public void t() {
        MutableDataSet options = new MutableDataSet();
//        options.set(Parser.REFERENCES_KEEP, KeepType.LAST)
//               .set(HtmlRenderer.INDENT_SIZE, 2)
//               .set(HtmlRenderer.PERCENT_ENCODE_URLS, true)
//               .set(HtmlRenderer.GENERATE_HEADER_ID, true)
//               .set(TablesExtension.COLUMN_SPANS, false)
//               .set(TablesExtension.APPEND_MISSING_COLUMNS, true)
//               .set(TablesExtension.DISCARD_EXTRA_COLUMNS, true)
//               .set(TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH, true)
//               .set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), TocExtension.create()));


        options.setFrom(ParserEmulationProfile.GITHUB_DOC);
        options.set(Parser.EXTENSIONS, Arrays.asList(
                AutolinkExtension.create(),
                //AnchorLinkExtension.create(),
                //EmojiExtension.create(),
                StrikethroughExtension.create(),
                TablesExtension.create(),
                TaskListExtension.create()
        ));

        // uncomment and define location of emoji images from https://github.com/arvida/emoji-cheat-sheet.com
        // options.set(EmojiExtension.ROOT_IMAGE_PATH, "");

        // Uncomment if GFM anchor links are desired in headings
        // options.set(AnchorLinkExtension.ANCHORLINKS_SET_ID, false);
        // options.set(AnchorLinkExtension.ANCHORLINKS_ANCHOR_CLASS, "anchor");
        // options.set(AnchorLinkExtension.ANCHORLINKS_SET_NAME, true);
        // options.set(AnchorLinkExtension.ANCHORLINKS_TEXT_PREFIX, "<span class=\"octicon octicon-link\"></span>");

        // References compatibility
        options.set(Parser.REFERENCES_KEEP, KeepType.LAST);

        // Set GFM table parsing options
        options.set(TablesExtension.COLUMN_SPANS, false)
               .set(TablesExtension.MIN_HEADER_ROWS, 1)
               .set(TablesExtension.MAX_HEADER_ROWS, 1)
               .set(TablesExtension.APPEND_MISSING_COLUMNS, true)
               .set(TablesExtension.DISCARD_EXTRA_COLUMNS, true)
               .set(TablesExtension.WITH_CAPTION, false)
               .set(TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH, true);

        // Setup List Options for GitHub profile which is kramdown for documents
        options.setFrom(ParserEmulationProfile.GITHUB_DOC);

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = null;
        try {
            String path = "/Users/zhangli/cloud/makdowns/tech-review/其他/测试markdown.md";
            document = parser.parseReader(new FileReader(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // /Users/zhangli/cloud/temporary/2017_07_30/大数据域.md

        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n

        html = wrapGitHubCss(html);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/zhangli/cloud/work/rule-data-center/mark-demo/tt.html")));
            writer.write(html);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String wrapGitHubCss(String html) {
        return "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"./c.css\">\n" +
                "<script src=\"./jquery-2.2.4.min.js\" type=\"text/javascript\"></script>\n" +
                "<script src=\"./toc.js\" type=\"text/javascript\"></script>\n" +
                "<style>\n" +
                "\t.markdown-body {\n" +
                "\t\tbox-sizing: border-box;\n" +
                "\t\tmin-width: 200px;\n" +
                "\t\tmax-width: 980px;\n" +
                "\t\tmargin: 0 auto;\n" +
                "\t\tpadding: 45px;\n" +
                "\t}\n" +
                "\n" +
                "\t@media (max-width: 767px) {\n" +
                "\t\t.markdown-body {\n" +
                "\t\t\tpadding: 15px;\n" +
                "\t\t}\n" +
                "\t}\n" +
                "</style>\n" +
                "<article class=\"markdown-body\">" +
                "<div id=\"toc\"></div>" +
                ""
                + html + "</article>" +
                "<script type=\"text/javascript\">\n" +
                "$(document).ready(function() {\n" +
                "    $('#toc').toc();\n" +
                "}); </script>";
    }


}
