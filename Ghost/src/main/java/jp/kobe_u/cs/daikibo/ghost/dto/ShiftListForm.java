package jp.kobe_u.cs.daikibo.ghost.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
import lombok.Data;

@Data
public class ShiftListForm {
    String mid;
    List<String> strDateList; // YYYY-MM-DD

    public List<Shift> toEntity() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Shift> list = new ArrayList<>();
        for (String strDt: strDateList) {
            Date dt = dateFormat.parse(strDt);
            Shift s = new Shift(null, mid, dt, false);
            list.add(s);
        }
        return list;
    }
}
