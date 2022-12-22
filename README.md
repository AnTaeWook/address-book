# 📔 주소록 API 서버

RestAPI 기반 CRUD 서비스를 제공하는 서버입니다

---

## API 명세
> GET /addresses : 주소록 전체 조회 <br/><br/>
> GET /addresses/{address-id} : 단일 주소록 조회 <br/><br/>
> POST /addresses : 주소록 등록 <br/><br/>
> PUT /addresses/{address-id} : 단일 주소록 수정 <br/><br/>
> DELETE /addresses/{address-id} : 단일 주소록 삭제 <br/>

<br/>

### 주소록 전체 조회 default 옵션

- 페이징 크기 10
- 이름 오름차순 정렬

### 쿼리 파라미터

- page: 페이지 번호
- size: 한 페이지에 노출할 주소 건수
- sort: 정렬 조건
- keyword: 이름 포함 조건 검색(default = "")

---

## 빌드 및 실행

**DB 연동** : **clone** 후 **src/main/resources/application.yml** 파일 내 mysql 연동 설정

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

8080 포트로 서버 가동됨

---
