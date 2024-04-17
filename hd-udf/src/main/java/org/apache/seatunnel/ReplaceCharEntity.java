package org.apache.seatunnel;

import org.apache.seatunnel.api.table.type.BasicType;
import org.apache.seatunnel.api.table.type.SeaTunnelDataType;
import org.apache.seatunnel.transform.sql.zeta.ZetaUDF;

import com.google.auto.service.AutoService;

import java.util.List;

@AutoService(ZetaUDF.class)
public class ReplaceCharEntity implements ZetaUDF {

    @Override
    public String functionName() {
        return "REPLACE_CHAR_ENTITY";
    }

    @Override
    public SeaTunnelDataType<?> resultType(List<SeaTunnelDataType<?>> argsType) {
        return BasicType.STRING_TYPE;
    }

    @Override
    public Object evaluate(List<Object> args) {
        return ReplaceCharEntityUtils.replaceAll((String) args.get(0));
    }
}
