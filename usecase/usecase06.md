[ユースケース:シフトを削除する]<br>
* 概要:管理者がシフトの削除をする。<br>
* アクター:管理者<br>
* 事前条件:管理者がシステムにログインしていること、管理者がシフトを登録していること。<br>
* 事後条件:カレンダーから該当シフト情報が削除される。<br>
* トリガー:管理者がカレンダーのシフト削除する日付をクリックする。<br>
* 基本フロー:<br>
    1.管理者はカレンダーから削除したい日付を押す。<br>
    2.システムは、その日付に登録されているシフト一覧を表示する。<br>
    3.管理者は削除したいシフトをクリックする。<br>
    4.システムは削除ボタンを表示する。<br>
    5.管理者は削除をクリックする。<br>
    6.システムはカレンダーから該当シフト情報を削除する。<br>
* 代替えフロー:<br>
    2a1:登録されているシフトがなければ、通知し、終了する。<br>
