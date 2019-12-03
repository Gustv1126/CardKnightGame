<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
@ModelAttribute를 사용하지 않은 방식인 경우::<br>
SampleDTO객체 이름: 소문자(sampleDTO)로 내부생성
<h2>SampleDTO:: ${sampleDTO }</h2>
<h2>PAGE_ModelAttribute::${page }</h2>
<h2>PAGE_param::${param.page }</h2>

</body>
</html>