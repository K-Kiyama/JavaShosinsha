# GHOST (Genpin Hugu Online Shift Timetable)<br>
玄品ふぐのシフト管理・確認アプリ（まだPoC）です．<br>

## 実行前の準備

### SQLテーブルの準備

テーブル名：ghost <br>
ユーザ名　：ghost <br>
パスワード：ghostpass <br>

### WARファイルの配備

方法１：build/libs内の"ghost-0.0.1-SNAPSHOT-plain.war"を、起動するサーバのtomcat/webapps内にコピー <br>

方法２：VSCodeでF5

### アクセス先URL

方法１の場合： <br>
http://サーバIP:8080/ghost-0.0.1-SNAPSHOT-plain.war/以下Path <br>

方法２の場合：
http://localhost:2289/以下Path <br>

### 操作・動作説明

1. 管理者画面でユーザを登録する <br>
    - http://サーバIP:8080/ghost-0.0.1-SNAPSHOT-plain.war/admin/master

2. 登録したユーザでログインする
    - http://サーバIP:8080/ghost-0.0.1-SNAPSHOT-plain.war/

3. ログインしたユーザでシフトを提出する

4. 管理者画面で提出されたシフトを確認、シフトを確定する

5. ユーザが確定したシフトを確認する



