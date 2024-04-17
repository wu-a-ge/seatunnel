package org.apache.seatunnel;

import org.apache.seatunnel.api.table.type.BasicType;
import org.apache.seatunnel.api.table.type.SeaTunnelDataType;
import org.apache.seatunnel.transform.sql.zeta.ZetaUDF;

import com.google.auto.service.AutoService;
import com.google.common.base.Strings;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AutoService(ZetaUDF.class)
public class FilterHtmlTag implements ZetaUDF {

    private static final Pattern re_cdata =
            Pattern.compile("//<!\\[CDATA\\[[^>]*//\\]\\]>", Pattern.CASE_INSENSITIVE); // 匹配CDATA
    private static final Pattern re_script =
            Pattern.compile(
                    "<\\s*script[^>]*>[^<]*<\\s*/\\s*script\\s*>",
                    Pattern.CASE_INSENSITIVE); // Script
    private static final Pattern re_style =
            Pattern.compile(
                    "<\\s*style[^>]*>[^<]*<\\s*/\\s*style\\s*>", Pattern.CASE_INSENSITIVE); // style
    private static final Pattern re_br = Pattern.compile("<br\\s*?/?>"); // 处理换行
    private static final Pattern re_h = Pattern.compile("</?\\w+[^>]*>"); // HTML标签
    private static final Pattern re_comment = Pattern.compile("<!--[^>]*-->"); // HTML注释
    private static final Pattern re_line = Pattern.compile("\n+");

    @Override
    public String functionName() {
        return "filter_tags";
    }

    @Override
    public SeaTunnelDataType<?> resultType(List<SeaTunnelDataType<?>> argsType) {
        return BasicType.STRING_TYPE;
    }

    @Override
    public Object evaluate(List<Object> args) {
        String htmlstr = (String) args.get(0);
        if (Strings.isNullOrEmpty(htmlstr)) return "";

        Matcher matcher;

        // 去掉CDATA
        matcher = re_cdata.matcher(htmlstr);
        htmlstr = matcher.replaceAll("");

        // 去掉SCRIPT
        matcher = re_script.matcher(htmlstr);
        htmlstr = matcher.replaceAll("");

        // 去掉style
        matcher = re_style.matcher(htmlstr);
        htmlstr = matcher.replaceAll("");

        // 将br转换为换行
        matcher = re_br.matcher(htmlstr);
        htmlstr = matcher.replaceAll("\n");

        // 去掉HTML 标签
        matcher = re_h.matcher(htmlstr);
        htmlstr = matcher.replaceAll("");

        // 去掉HTML注释
        matcher = re_comment.matcher(htmlstr);
        htmlstr = matcher.replaceAll("");

        // 去掉多余的空行
        htmlstr = re_line.matcher(htmlstr).replaceAll("\n");
        // 替换实体
        htmlstr = ReplaceCharEntityUtils.replaceAll(htmlstr);
        return htmlstr;
    }
}
