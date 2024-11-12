for /F "usebackq tokens=1,2 delims==" %%i in (`wmic os get LocalDateTime /VALUE 2^>NUL`) do if '.%%i.'=='.LocalDateTime.' set ldt=%%j
set ldt=%ldt:~0,4%-%ldt:~4,2%-%ldt:~6,2% %ldt:~8,2%:%ldt:~10,2%:%ldt:~12,6%

if exist .git\ (
 echo Ok
) else (
 git init
)

@echo off
set /p messComit=Qual a mensagem de commit?: 
echo ok %dmessComit%

git add -A
git commit -m "PUSH [%ldt%] %messComit%"
git push -f https://<TOKEN>@github.com/<USUARUO>/<REPOSITORIO>.git master
