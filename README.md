# ๐ ์ฃผ์๋ก API ์๋ฒ

RestAPI ๊ธฐ๋ฐ CRUD ์๋น์ค๋ฅผ ์ ๊ณตํ๋ ์๋ฒ์๋๋ค

---

## API ๋ช์ธ
> GET /addresses : ์ฃผ์๋ก ์ ์ฒด ์กฐํ <br/><br/>
> GET /addresses/{address-id} : ๋จ์ผ ์ฃผ์๋ก ์กฐํ <br/><br/>
> POST /addresses : ์ฃผ์๋ก ๋ฑ๋ก <br/><br/>
> PUT /addresses/{address-id} : ๋จ์ผ ์ฃผ์๋ก ์์  <br/><br/>
> DELETE /addresses/{address-id} : ๋จ์ผ ์ฃผ์๋ก ์ญ์  <br/>

<br/>

### ์ฃผ์๋ก ์ ์ฒด ์กฐํ default ์ต์

- ํ์ด์ง ํฌ๊ธฐ 10
- ์ด๋ฆ ์ค๋ฆ์ฐจ์ ์ ๋ ฌ

### ์ฟผ๋ฆฌ ํ๋ผ๋ฏธํฐ

- page: ํ์ด์ง ๋ฒํธ
- size: ํ ํ์ด์ง์ ๋ธ์ถํ  ์ฃผ์ ๊ฑด์
- sort: ์ ๋ ฌ ์กฐ๊ฑด
- keyword: ์ด๋ฆ ํฌํจ ์กฐ๊ฑด ๊ฒ์(default = "")

---

## ๋น๋ ๋ฐ ์คํ

**DB ์ฐ๋** : **clone** ํ **src/main/resources/application.yml** ํ์ผ ๋ด mysql ์ฐ๋ ์ค์ 

### macos(console)

```
./gradlew build  
cd build/libs  
java -jar {address-server-name}-SNAPSHOT.jar  
```

### windows(console)

```
gradlew.bat
gradlew build
cd build/libs
java -jar {address-server-name}-SNAPSHOT.jar
```

8080 ํฌํธ๋ก ์๋ฒ ๊ฐ๋๋จ

---
