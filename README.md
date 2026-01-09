<h1 class="topo">:musical_note: Screen Music 🎵</h1>
<p>O ScreenMusic é fruto de um desafio da Alura do curso 'Java: persistência de dados e consultas com Spring Data JPA', dedicado ao final do curso para consolidação dos conhecimentos adquiridos.
O mesmo é uma forma de guardar referências de artistas dentro de músicas, como forma de chave estrangeira, para assim, relacionar os mesmo. Utiliza-se de enums, JPA, Spring boot, PostgreSQL, e outras
atribuições e métodos aprendidos dentro do curso.<br>
É uma forma de aplicar os conhecimentos adquiridos para assim, formentar o conhecimento por meio da prática. O mesmo foi desenvolvido usando a IDE do Intelij e com dependências de JPA e comunicações com o Banco
de Dados Postgre, utilizando-se do Maven para organização dessas dependências.</p>

<h1>Sumário</h1>
<ol>
  <li><a href="#dependencia">Variáveis de ambiente</a></li>
  <li><a href="#projeto">Projeto</a></li>
  <li><a href="#doc">Organização de documentação</a></li>
</ol>

<h1 class="dependecia">Variáveis de ambiente :pushpin:</h1>
<p>O projeto necessita que o usuário tenha o <strong>PostgreSQL</strong> baixado na máquina e defina algumas variáveis de ambiente para o JPA realizar a comunicação com o banco de dados.</p>
<ul>
  <li>${DB_HOST} - host que será utilizado para acesso do banco de dados (localhost).</li>
  <li>${DB_NAME} - nome do banco de dados que será utilizado (do projeto, não do SGBD).</li>
  <li>${DB_USER} - Usuário que utilizará para acesso do banco de dados (pode ser postgres ou qualquer um)</li>
  <li>${DB_PASSWORD} - Senha do banco de dados (postgre) a ser utilizado</li>
</ul>
<p>É também necessário, que o banco de dados, seja criado, respeitando o nome que foi declarado como
variável de ambiente. Ou seja, acesso via pgAdmin do postgree e criar o banco de dados.</p>

<p>Exemplo: </p>
<h6>Variável de ambiente</h6>
<img width="276" height="24" alt="image" src="https://github.com/user-attachments/assets/f5d20de0-fc11-4542-8a75-0ce0b95ea848" />
<h6>Banco criado</h6>
<img width="242" height="97" alt="image" src="https://github.com/user-attachments/assets/a28aa736-0511-4e81-8055-639f2d133dbb" />


<h1 class="projeto">Projeto 🛠️</h1>
<p>Algumas fotos do projeto em funcionamento: </p>
<h3>Cadastro de artista</h3>
<img width="440" height="452" alt="image" src="https://github.com/user-attachments/assets/c8a74e82-948c-4595-b478-dd44bd325870" />
<h3>Cadastro de música</h3>
<img width="401" height="509" alt="image" src="https://github.com/user-attachments/assets/6b012d8f-d8e2-4c3b-b481-2c270fd7bf45" />
<h3>Lista de músicas</h3>
<img width="395" height="396" alt="image" src="https://github.com/user-attachments/assets/a782d8c9-74d4-4a27-9da8-0877d8ba8eda" />
<h3>Busca de músicas por artista</h3>
<img width="417" height="300" alt="image" src="https://github.com/user-attachments/assets/4b3de2e3-eac5-4fe3-bf87-435ebd3474a8" />


<h1 class="doc">Organização e Documentação: :bookmark_tabs:</h1>
<p>A organização foi feita por meio da seguinte organização de pastas dentro do projeto:</p>
<ul>
  <li>Classes</li>
  <ul>
    <li>Artista</li>
    <li>ArtistaRepository</li>
    <li>Musica</li>
    <li>Tipo</li>
  </ul>
  <li>Principal</li>
  <ul>
    <li>Main</li>
  </ul>
  <li>ScreenMusicApplication</li>
</ul>

<h2>Classes</h2>
<p>Responsável por guardas as classes do projeto que iriam ser utilizadas. Ex.: classes padrão, enums e interfaces.</p>

<h3>Artista</h3>
<p>Classe que contém escopo de criação dos objetos do tipo artista. O mesmo apresenta anotações providas pela JPA para criação da tabela "artistas" e com suas determinadas colunas de destaque: nome, tipo,
lista de músicas do artista.</p>

<h3>ArtistaRepository</h3>
<p>Por sua vez, a interface ArtistaRepository é utilizada para definir uma interface que fará a comunicação da JPA com o banco de dados. Extendendo JpaRepository&ltArtista,Long&gt.
Desta forma, realizando alguns procedimentos com JPQL e derived query.</p>

<h3>Musica</h3>
<p>É uma classe semelhante à Artista, porém com os atributos de um objeto música (nome, artista autoral). O mesmo fazendo um relacionamento @ManyToOne com Artista.</p>

<h3>Tipo</h3>
<p>Classe enum, responsável por definir alguns tipos para o Artista, se é composto por um solo, uma dupla ou banda.</p>

<h2>Principal</h2>
<h3>Main</h3>
<p>Classe responsável por mostrar o menu e realizar o chamado de métodos definidos dentro da classe para trabalhar com o projeto.</p>

<h2>ScreenMusicApplication</h2>
<p>Classe de inicialização padrão do Springboot, apresentando também uma interface @autowired para comunicação com o banco de dados (ArtistaRepository).</p>


<h1>Retornar ao topo</h1>
<a href="#topo">Retornar ao topo.</a>
