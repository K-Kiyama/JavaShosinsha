# ユースケース 3： ユーザ情報を削除する．

## 概要
管理者が従業員のユーザ情報を削除する

## アクター
- 管理者

## 事前条件
-　ユーザの情報が登録された状態．

## 事後条件
- 従業員のユーザ情報が削除された状態．

## トリガ―
- 管理者が「ユーザ情報の削除」ボタンを押す。

## 基本フロー
1. システムは，ユーザ情報削除画面を表示する．
2. 管理者はユーザIDとパスワードを入力し次へを押す．
3. システムは，入力されたユーザIDでユーザ情報を検索し，パスワードが一致するかチェックする．
4. パスワードが一致すれば，システムは登録されているユーザ情報を表示する．
5. 管理者は削除ボタンを押す．
6. システムは，ユーザ情報を削除する，

## 代替フロー
### 代替フロー1
- 3a.1  基本フロー3でユーザIDがなければ，システムはログインエラーを出し，1に戻る．
### 代替フロー2
- 4a.1  基本フロー4でパスワードが一致しない場合，システムはログインエラーを出し，1に戻る．
