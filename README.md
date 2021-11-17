# GlitchMochi

## Escopo do projeto

O projeto GlitchMochi tem como objetivo a criação de um site mobile first para recomendações de games e mangás, no qual será dividido em: página principal (home page), recomendação de jogo (game recommendation) e recomendação de mangá (manga recommendation).

### DataBase

Em nosso banco de dados, foi criado as tabelas que serão utilizados no projeto, resultando no diagrama final
![image](https://user-images.githubusercontent.com/73084673/142273702-c822a741-f94f-4a5b-bc3a-9706e99c0424.png)

### Back-End

Para o Back-End, criou-se os modelos (models) e enums (ENUMS) das tabelas criadas no dbeaver (banco de dados). Por exemplo o GameRecommendation.models
![image](https://user-images.githubusercontent.com/73084673/142274304-aaa23664-e1d5-407d-a003-32525f42edf0.png)

Assim como o seu respectivo GameRecommendationDAO (outros também foram feitos, porém neste readme, foi escolhido apenas um para servir como exemplo)
![image](https://user-images.githubusercontent.com/73084673/142274479-1888b649-33bc-442f-84de-54933e630e0d.png)

E por fim, criamos o application.kt para mandar os dados à um endereço de site (no caso localhost8087)
![image](https://user-images.githubusercontent.com/73084673/142276812-3e523fee-f39c-48ab-ad3b-2b4ba3a48a71.png)


### Front-End

Para o Front-End, criou-se a classe networkhelper para ajudar a fazer a conexão entre o back-end e o front-end, pegando as informações necessárias.

![image](https://user-images.githubusercontent.com/73084673/142279626-c0b866d2-519c-4b96-9367-be94ea1c0a9a.png)

Na classe main estamos apenas referenciando o appwidget, que por sua vez está definindo o site.

![image](https://user-images.githubusercontent.com/73084673/142279927-34facb2c-7ea4-4b51-8cfa-4934cc8251cf.png)

#### Mockups
> ##### Mockup do Homepage
>> ![image](https://user-images.githubusercontent.com/79462846/142285840-fbf52136-8adf-4692-ae9d-d9c56ce1ca7a.png)
> ##### Mockup dos Posts
>> ![image](https://user-images.githubusercontent.com/79462846/142286988-fd4df1e2-0016-44cf-b164-3393a1655f54.png)



Assim foram definido os 3 tipos de página:

#### HomePage
> ![image](https://user-images.githubusercontent.com/73084673/142280580-ee0f9f87-9e05-4766-aa4b-5408cba7ba24.png)

#### MangaRecommendation
> ![image](https://user-images.githubusercontent.com/73084673/142283069-28f6ff32-c972-48c8-b4ae-7dbc8a5b7605.png)

#### GameRecommendation
> ![image](https://user-images.githubusercontent.com/73084673/142283131-c2575454-8f55-4a41-ad60-fcb6bccffb24.png)

## Como rodar?

Para que o site/aplicação consiga ser simulado, é necessário rodar o application.kt do BackEnd com a máquina virtual do mariaDB, ligada, para que seja possível acessar os dados do banco de dados. A seguir, deve-se rodar o código em dart do flutter para que a página da web (no caso o chrome) seja iniciada, mostrando a aplicação funcional.
