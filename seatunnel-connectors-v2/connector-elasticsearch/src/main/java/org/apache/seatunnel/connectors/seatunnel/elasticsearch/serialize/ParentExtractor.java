package org.apache.seatunnel.connectors.seatunnel.elasticsearch.serialize;

import org.apache.seatunnel.api.table.type.SeaTunnelRow;
import org.apache.seatunnel.api.table.type.SeaTunnelRowType;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.function.Function;

@AllArgsConstructor
public class ParentExtractor implements Function<SeaTunnelRow, String>, Serializable {
    private final int fieldIndex;

    @Override
    public String apply(SeaTunnelRow seaTunnelRow) {
        return seaTunnelRow.getField(fieldIndex).toString();
    }

    public static Function<SeaTunnelRow, String> createParentExtractor(
            SeaTunnelRowType rowType, String parentField) {
        if (parentField == null) {
            return row -> null;
        }
        int fieldIndex = rowType.indexOf(parentField);
        return new ParentExtractor(fieldIndex);
    }
}
