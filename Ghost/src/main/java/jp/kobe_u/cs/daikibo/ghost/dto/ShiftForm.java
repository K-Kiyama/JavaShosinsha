package jp.kobe_u.cs.daikibo.ghost.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.kobe_u.cs.daikibo.ghost.entity.Shift;
import lombok.Data;

@Data
public class ShiftForm {
    String strdate; // YYYY-MM-DD

    public Shift toEntity(String mid) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(strdate);
        Shift s = new Shift(null, mid, date, false);
        return s;
    }
}
