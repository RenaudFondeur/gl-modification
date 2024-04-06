package us.codecraft.webmagic.selector;

import us.codecraft.webmagic.utils.Experimental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Borrowed from https://code.google.com/p/cx-extractor/
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.4.1
 *
 */
@Experimental
public class SmartContentSelector implements Selector {

    public String processHTML(String html) {
        html = html.replaceAll("(?is)<!DOCTYPE.*?>", "");
        html = html.replaceAll("(?is)<!--.*?-->", "");				// remove html comment
        html = html.replaceAll("(?is)<script.*?>.*?</script>", ""); // remove javascript
        html = html.replaceAll("(?is)<style.*?>.*?</style>", "");   // remove css
        html = html.replaceAll("&.{2,5};|&#.{2,5};", " ");			// remove special char
        html = html.replaceAll("(?is)<.*?>", "");
        return html;
    }

    public ArrayList<Integer> initIndexDistribution(List<String> lines, int blocksWidth) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < lines.size() - blocksWidth; i++) {
            int wordsNum = 0;
            for (int j = i; j < i + blocksWidth; j++) {
                lines.set(j, lines.get(j).replaceAll("\\s+", ""));
                wordsNum += lines.get(j).length();
            }
            result.add(wordsNum);
        }
        return result;
    }

    @Override
    public String select(String html) {
        html = processHTML(html);
        StringBuilder text = new StringBuilder();
        text.setLength(0);
        
        List<String> lines = Arrays.asList(html.split("\n"));
        int blocksWidth =3;
        ArrayList<Integer> indexDistribution = initIndexDistribution(lines, blocksWidth);

        int start = -1;
        int end = -1;
        int threshold = 86;

        boolean boolstart = false;
        boolean boolend = false;

        for (int i = 0; i < indexDistribution.size() - 1; i++) {
            if (indexDistribution.get(i) > threshold && ! boolstart && (indexDistribution.get(i+1).intValue() != 0 || indexDistribution.get(i+2).intValue() != 0 || indexDistribution.get(i+3).intValue() != 0)) {
                boolstart = true;
                start = i;
                continue;
            }
            if (boolstart && (indexDistribution.get(i).intValue() == 0 || indexDistribution.get(i+1).intValue() == 0)) {
                end = i;
                boolend = true;
            }
            if (boolend) {
                StringBuilder tmp = new StringBuilder();
                for (int ii = start; ii <= end; ii++) {
                    if (lines.get(ii).length() < 5) continue;
                    tmp.append(lines.get(ii) + "\n");
                }
                String str = tmp.toString();
                if (str.contains("Copyright")   ) continue;
                text.append(str);
                boolstart = boolend = false;
            }
        }
        return text.toString();
    }

    @Override
    public List<String> selectList(String text) {
        throw new UnsupportedOperationException();
    }
}