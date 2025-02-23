set now=%date:~6,4%_%date:~3,2%_%date:~0,2%_%time:~0,2%:%time:~3,2%
echo.%now%


if exist .git\ (
 echo Ok
) else (
 git init
)

git config user.name "USUARIOGITHUB"
git config user.email "NOME@MAIL.com"

@echo off
set /p messComit=Qual a mensagem de commit?: 

git add -A
git commit -m "%messComit% %now%"
git push -f https://<TOKEN>@github.com/<USUARUO>/<REPOSITORIO>.git master
