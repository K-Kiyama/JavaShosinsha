package jp.kobe_u.cs.daikibo.ghost.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Shift エンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long seq;         //通し番号
    String mid;       //作成者
    @Temporal(TemporalType.DATE)
    Date date;        //希望日
    boolean flag;     //確定しているかどうか
}
