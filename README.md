# このリポジトリは何？
[JJUGナイトセミナー「初めてのひとのためのSpring/Spring Boot」](https://jjug.doorkeeper.jp/events/137022)（2022年5月23日開催）の「実演編」におけるライブコーディングの完成版です。

# 環境
- JDK 17
- Spring Boot 2.7
- Spring Framework 5.3
- Thymeleaf 3
- Spring JDBC 5.3
- PostgreSQL 14.2
  - 今回はDocker Desktopで実行しています。
- curlコマンド
- jqコマンド

# 動かし方
## PostgreSQLの起動
```shell
./docker-run-postgresql.sh
```

## アプリケーションの起動
src/main/javaディレクトリの `com.example.springmemo.SpringMemoApplication` クラスにある `main()` メソッドから起動してください。

## ブラウザでのアクセス
ブラウザで http://localhost:9000/ にアクセスしてください。

## curlコマンドでの実行
次のコマンドを実行してください。

### 全memo取得
```shell
curl -v -X GET http://localhost:9000/memos | jq
```

### memo追加
```shell
curl -v -X POST -H "Content-Type: application/json" -d "{\"content\":\"aaa\"}" http://localhost:9000/memos
```

### Actuator
```shell
curl -v -X GET http://localhost:9000/actuator | jq
curl -v -X GET http://localhost:9000/actuator/health | jq
curl -v -X GET http://localhost:9000/actuator/metrics | jq
curl -v -X GET http://localhost:9000/actuator/metrics/jvm.threads.live | jq
```

# Spring Bootを使わずにほぼ同じアプリケーションを作成したサンプル
- https://github.com/MasatoshiTada/spring-memo-no-boot
  - 各 `config` パッケージでどんなBeanを定義しているかに注目してください。それ以外のパッケージは、ほぼこのリポジトリと同じです（ `main()` メソッドだけちょっと違います）。

# ためになる資料たち
- 初めてのひとのためのSpring/Spring Boot
  - スライド(TBD)
  - 動画(TBD)
- 今こそ知りたいSpring DI x AOP
  - [スライド](https://www.docswell.com/s/MasatoshiTada/Z818E5-spring-di-aop-for-every-developers)
  - [動画](https://www.youtube.com/watch?v=LGtdpsmMfvI)
- プロになるためのSpring上級知識
  - [スライド](https://www.docswell.com/s/MasatoshiTada/K1XMLK-advanced-spring-for-professionals)
  - [動画](https://www.youtube.com/watch?v=c5ha8FmdNmw)
- 図解で学ぶSpring MVC
  - [スライド](https://speakerdeck.com/otty375/architecture-of-spring-mvc)
  - [動画](https://youtu.be/szqIWhPnzjM?t=1635)
- 怖くないSpring Bootのオートコンフィグレーション
  - [スライド](https://www.slideshare.net/KouheiToki/spring-boot-250772616)
  - [動画](https://www.youtube.com/watch?v=8saUt8sxgsI)
- 今こそ知りたいSpring Security
  - [スライド](https://www.slideshare.net/KouheiToki/spring-fest2020-springsecurity)
  - [動画](https://youtu.be/o_opWd9cZ10)
- 今こそ知りたいSpring Test
    - [スライド](https://speakerdeck.com/rshindo/spring-fest-2020)
    - [動画](https://youtu.be/TSuCehg7J24)
- [Spring Fest 2020のBeginner Track](https://springfest2020.springframework.jp/#sessions)
- 書籍
  - [改訂新版Spring入門](https://www.amazon.co.jp/dp/B01H12Z40U/)
  - [Spring徹底入門](https://www.amazon.co.jp/dp/B01IEWNLBU/)
    - 僕のブログ[令和時代に「Spring入門」「Spring徹底入門」を読むとき気をつけるべきN個のこと](https://qiita.com/suke_masa/items/392976749fce94a8ef1f)も合わせて読んでください。
- Spring公式ドキュメント
  - [英語(公式)](https://docs.spring.io/spring-framework/docs/current/reference/html/)
  - [日本語訳(非公式)](https://spring.pleiades.io/spring-framework/docs/current/reference/html/)
- Spring Boot公式ドキュメント
    - [英語(公式)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
    - [日本語訳(非公式)](https://spring.pleiades.io/spring-boot/docs/current/reference/html/)
