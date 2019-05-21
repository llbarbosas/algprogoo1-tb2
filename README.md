# algprogoo1-tb2
Segundo trabalho da disciplina de Algoritmos e Programação Orientada a Objetos 1 da UFMS. O trabalho visa o desenvolvimento de um sistema fictício de apoio a pesquisadores de Aprendizado de Máquina em java.

**Data de entrega:** 14/06/2019 às 23h55.

**Critérios de avaliação:** Completude do modelo (peso 4), corretude de funcionalidades (peso 5), classe de teste com todos os métodos sendo testados (peso 1).

<br />

## TODO
* [X] Criação das classes com seus atributos e métodos referentes ao diagrama de classe do trabalho
* [ ] Implementação da classe Algoritmo
* [ ] Implementação da classe MedidaAvaliacao
* [ ] Implementação da classe Dataset
* [ ] Implementação da classe ValorAvaliacao
* [ ] Implementação da classe Resultado
* [ ] Implementação da classe Experimento
* [ ] Implementação da classe de teste

## Descrição das classes

### Algoritmo
Esta é a classe responsável por fornecer a abstração simplificada de um algoritmo de Aprendizadode Máquina. 

Nesta abstração, temos os seguintes atributos:
* **nome:**  variável textual que armazena o nome do algoritmo.
* **parametros:**   vetor  com  três  posições  de  variáveis  em  ponto  flutuante  que  armazena  osparâmetros  do  algoritmo  utilizado.   Um  algoritmo  pode  ter  de  0  a  3  parâmetros.   Assim,nem todas as posições do vetor poderão ser utilizadas.  Posições não utilizadas deverão serpreenchidas com o valor curinga Float.MAX_VALUE.

Essa classe conta com os seguintes métodos:
* **Método construtor:**  deve receber o nome e o conjunto de parâmetros do algoritmo, iniciali-zando, da maneira apropriada, as variáveis de instância.
* **getNome:**  deve retornar o nome do algoritmo.
* **getParametros:**  deve retornar o conjunto de parâmetros do algoritmo.

### MedidaAvaliacao
Neste classe, temos a abstração de uma medida de avaliação que poderá ser utilizada pelos pesquisadores para avaliar seus algoritmos. 

São atributos desta classe:
* **nome:**  variável textual que armazena o nome da medida de avaliação.
* **menorValor:**   variável  em  ponto  flutuante  que  armazena  o  menor  valor  que  a  medida  deavaliação pode assumir.
* **maiorValor:**   variável  em  ponto  flutuante  que  armazena  o  maior  valor  que  a  medida  deavaliação pode assumir.

Além disso, a classe tem os seguintes métodos:
* **Construtor:**   deve  receber  como  parâmetros  o  nome  da  medida  de  avaliação,  seumenor valor e seu maior valor, respectivamente.  Deve inicializar, de maneira adequada, asvariáveis de instância.
* **getNome:**  deve retornar o nome da medida de avaliação.
* **getMenorValor:**  deve retornar o menor valor que a medida de avaliação pode assumir.
* **getMaiorValor:**  deve retornar o maior valor que a medida de avaliação pode assumir.

### ValorAvaliacao
Classe responsável por representar um valor de avaliação obtida por um algoritmo em uma deter-minada medida de avaliação.

São seus atributos:
* **valor:**  variável de ponto flutuante que armazena o score obtido pelo algoritmo na medida deavaliação utilizada.
* **medida:**   variável  do  tipo  MedidaAvaliacao  que  armazena  a  medida  de  avaliação  à  qualpertence este valor obtido.

São métodos desta classe:
* **Método construtor:**  deve receber uma instância da classe MedidaAvaliação, que representaa  medida  de  avaliação  à  qual  pertence  este  valor.   Deve,  também,  inicializar,  de  maneiraadequada, as variáveis de instância.
* **setValor:**  método responsável por armazenar o valor obtido pelo algoritmo na medida deavaliação.  Deve receber como parâmetro o valor da medida.  Este valor deve ser validado,de  acordo  com  os  limites  aceitos  pela  medida  utilizada.   Caso  o  valor  seja  aceito,  deve-se  guardá-lo  na  variável  de  instância  correspondente  e  retornar  o  valortrue,  assinalandoque a atribuição foi bem sucedida.  Caso contrário, deve imprimir uma mensagem na telainformando da impossibilidade de atribuição e retornar o valorfalse.
* **getMedida:**  deve retornar a medida de avaliação utilizada.
* **getValor:**  deve retornar o valor da medida de avaliação armazenada no objeto.

###  Dataset
Esta classe fornece uma abstração de um conjunto de dados utilizado no experimento.  

Contem osseguintes atributos:
* **numExemplos:**  variável inteira que armazena o número de exemplos contidos no conjuntode dados.
* **numAtributos:**  variável inteira que armazena o número de atributos contidos no conjuntode dados.
* **numClasses:**  variável  inteira  que  armazena  o  número  de  classes  contidas  no  conjunto  dedados.
* **nome:**  variável textual que armazena o nome do conjunto de dados.

São métodos desta classe:
* **Método  construtor:**  deve  receber  como  parâmetros  o  número  de  exemplos,  o  número  deatributos,  o  número  de  classes  e  o  nome  do  conjunto  de  dados,  inicializando,  de  maneiraadequada, as variáveis de instância.
* **getNumExemplos:**  deve retornar o número de exemplos do conjunto de dados.
* **getNumAtributos:**  deve retornar o número de atributos do conjunto de dados.
* **getNumClasses:**  deve retornar o número de classes do conjunto de dados.
* **getNome:**  deve retornar o nome do conjunto de dados.

### Resultado
Esta  classe  fornece  uma  abstração  de  um  resultado  obtido  nos  experimentos  realizados  de  umalgoritmo em um conjunto de dados, de acordo com algumas medidas de avaliação.

São atributosdesta classe:
* **algoritmo:**  variável do tipo Algoritmo que armazena o algoritmo e suas configurações queforam utilizadas para obtenção deste resultado.
* **dataset:**  variável do tipo Dataset que armazena o conjunto de dados utilizado na obtençãodeste resultado.
* **avaliacao:**  vetor de três posições do tipo ValorAvaliacao que armazenam os valores de ava-liação  obtidas  pelo  algoritmo  no  conjunto  de  dados,  de  acordo  com  até  três  medidas  deavaliação.  Um algoritmo pode ser avaliado utilizando de 1 a 3 medidas de avaliação.  Assim,nem todas as posições do vetor estarão preenchidas.  Posições vazias devem conter o valornull.

São métodos desta classe:
* **Método construtor:**  deve receber como parâmetros o algoritmo e o conjunto de dados uti-lizado  na  obtenção  deste  resultado.   Deve  inicializar  as  variáveis  de  instância  da  maneiraadequada.
* **getAlgoritmo:**  deve retornar o algoritmo utilizado neste resultado. 
* **getDataset:**  deve retornar o conjunto de dados utilizado neste resultado.
* **getNomeDoAlgoritmo:**  deve retornar o nome do algoritmo utilizado neste resultado.
* **getNomeDoDataset:**  deve retornar o nome do conjunto de dados utilizado neste resultado.
* **addAvaliacao:**  método utilizado para adicionar um resultado de avaliação do algoritmo noconjunto de dados.  Uma avaliação s ́o poderá ser adicionada se houver espaço no vetor deavaliações.  Além disso, s ́o é poss ́ıvel haver uma avaliação para cada medida de avaliação.Assim, não é poss ́ıvel haver no vetor de avaliações duas ou mais avaliações que utilizem amesma medida de avaliação.  Este método deve retornartruecaso a adição de uma avaliaçãoseja bem sucedida.  Caso a adição de uma avaliação não seja poss ́ıvel, deve imprimir umamensagem na tela informando da impossibilidade e retornar o valorfalse.
* **getAvaliacoes:**  deve retornar o vetor de avaliações obtidas neste resultado.
* **getAvaliacaoPorMedida:**  deve receber como parâmetro o nome da medida de avaliação quese  deseja  obter  o  valor.   Caso  a  medida  não  seja  encontrada  no  vetor  de  avaliações,  estemétodo deve retornarnull.  Caso a medida seja encontrada, seu objeto correspondente dotipoValorAvaliacaodeve ser retornado.

### Experimento
Esta é a classe que armazena todos os dados dos experimentos e que permite ao pesquisador aobtenção de algumas informações sobre o experimento.

São atributos desta classe:
* **dia:**  variável inteira que armazena o dia de realização do experimento.
* **mes:**  variável inteira que armazena o mês de realização do experimento.
* **ano:**  variável inteira que armazena o ano de realização do experimento.
* **resultados:**  vetor de 10 posições do tipo Resultado que armazena os resultados obtidos poralgoritmos em conjuntos de dados.  Um experimento pode ter de 1 a 10 resultados.  Assim,caso uma posição não seja preenchida, ela deve assumir valornull.

São métodos desta classe:
* **Método construtor:**  deve receber como parâmetros o dia,  o mês e o ano do experimento.Deve inicializar as variáveis de instância de maneira adequada.
* **addResultado:** método utilizado para adição de um resultado no experimento.  Um resultados ́o pode ser adicionado se não exceder o máximo de 10 resultados.  Além disso, não é poss ́ıvelhaver repetição de resultados.  Desta forma, seu vetor de resultados não deve conter duasvezes resultados do mesmo algoritmo, com os mesmos parâmetros, no mesmo conjunto dedados.  Caso um resultado seja adicionado com sucesso, este método deve retornar o valortrue.  Caso o resultado não seja adicionado, deve-se imprimir uma mensagem informativa natela e retornar o valorfalse.
* **getValoresResultados:**  deve receber como parâmetro o nome da medida que deseja-se sabero valor nos diferentes resultados.  Este método retorna um vetor de 10 posições, contendoo  valor  da  medida  de  avaliação  nos  (até)  10  resultados.   Caso  a  medida  não  tenha  sidoutilizada em um determinado resultado, deve-se preencher a posição correspondente no vetorde resposta com o valor curinga Float.MAX_VALUE.
* **getMediaResultados:**  deve receber como parâmetro o nome da medida que deseja-se saber amédia ao longo dos diferentes resultados.  A média deve ser calculada considerando o númerode resultados válidos contidos no conjunto de resultados (ou seja, considerando o númerode resultados que, de fato, utilizaram aquela medida de avaliação).  Deve retornar um valorem ponto flutuante contendo a média.  Caso a medida não tenha sido utilizada em nenhumresultado, deve retornar o valor curinga Float.MAX_VALUE.
* **getMediaResultadosPorAlgoritmo:**  similar ao método anterior, deseja-se saber a média deuma  medida  obtida  por  um  algoritmo  ao  longo  dos  diferentes  resultados.   Deve  recebercomo parâmetros o nome do algoritmo e o nome da medida a serem pesquisadas.  A médiadeve  ser  calculada  considerando  o  número  de  resultados  válidos  contidos  no  conjunto  deresultados (ou seja, considerando o número de resultados para o algoritmo pesquisado que,de fato, utilizaram aquela medida de avaliação).  Deve retornar um valor em ponto flutuantecontendo a média.  Caso a medida ou o algoritmo não tenham sido utilizados em nenhumresultado, deve retornar o valor curinga Float.MAX_VALUE.
* **getMediaResultadosPorDataset:** também similar ao método anterior, deseja-se saber a médiade uma medida obtida por qualquer algoritmo ao longo dos diferentes resultados que utiliza-ram um determinado conjunto de dados.  Deve receber como parâmetros o nome do conjuntode dados e o nome da medida a serem pesquisadas.  A média deve ser calculada considerandoo número de resultados válidos contidos no conjunto de resultados (ou seja, considerando onúmero de resultados que, de fato, utilizaram aquela medida de avaliação naquele conjuntode dados).  Deve retornar um valor em ponto flutuante contendo a média.  Caso a medida ouo algoritmo não tenham sido utilizados em nenhum resultado, deve retornar o valor curinga Float.MAX_VALUE.
* **getMelhorResultado:**  deve receber como parâmetro do nome da medida a ser pesquisada eretornar o objeto do tipo Resultado que apresenta o maior valor para a medida pesquisada.Caso a medida não tenha sido utilizada, deve-se retornar o valornull.
* **getMelhorResultadoPorAlgoritmo:**  deve  receber  como  parâmetros  o  nome  da  medida  e  onome  do  algoritmo  a  serem  pesquisados.   Deve  retornar  o  objeto  do  tipo  Resultado  queapresenta o maior valor para a medida pesquisada apresentado pelo algoritmo especificado.Caso  a  medida  e  o  algoritmo  não  tenham  sido  utilizados  em  um  mesmo  resultado,  deveretornar o valornull.
* **getMelhorResultadoPorDataset:**  similar ao anterior, deve receber como parâmetros o nomeda  medida  e  o  nome  do  conjunto  de  dados  a  serem  pesquisados.   Deve  retornar  o  objetodo tipo Resultado que apresenta o maior valor para a medida pesquisada apresentado porqualquer algoritmo no conjunto de dados especificado.  Caso a medida e o conjunto de dadosnão tenham sido utilizados em um mesmo resultado, deve retornar o valornull.
* **getPiorResultado:**  deve  receber  como  parâmetro  do  nome  da  medida  a  ser  pesquisada  eretornar o objeto do tipo Resultado que apresenta o menor valor para a medida pesquisada.Caso a medida não tenha sido utilizada, deve-se retornar o valornull.
* **getPiorResultadoPorAlgoritmo:**  deve receber como parâmetros o nome da medida e o nomedo algoritmo a serem pesquisados.  Deve retornar o objeto do tipo Resultado que apresentao menor valor para a medida pesquisada apresentado pelo algoritmo especificado.  Caso amedida e o algoritmo não tenham sido utilizados em um mesmo resultado, deve retornar ovalornull.
* **getPiorResultadoPorDataset:**  similar ao anterior, deve receber como parâmetros o nome damedida e o nome do conjunto de dados a serem pesquisados.  Deve retornar o objeto do tipoResultado que apresenta o menor valor para a medida pesquisada apresentado por qualqueralgoritmo  no  conjunto  de  dados  especificado.   Caso  a  medida  e  o  conjunto  de  dados  nãotenham sido utilizados em um mesmo resultado, deve retornar o valornull.
* **getDatasetMelhorResultado:**  deve receber como parâmetro o nome da medida a ser consi-derada e retornar,  dentre todos os resultados apresentados,  o objeto do tipo Dataset querepresenta o conjunto de dados que obteve o maior valor da medida especificada.  Caso amedida não tenha sido utilizada em nenhum resultado, deve retornarnull.
* **getDatasetMelhorResultadoAlgoritmo:**  deve receber como parâmetros os nomes da medidae do algoritmo a serem considerados.  Este método deve retornar um objeto do tipo Datasetque representa o conjunto de dados no qual o algoritmo especificado apresentou o maior valorda medida especificada.  Caso a medida e o algoritmo não tenham sido utilizados juntos emnenhum resultado, deve retornarnull.
* **getNomesAlgoritmosUtilizados:**  deve  retornar  um  vetor  contendo  o  nome  dos  algoritmosutilizados,  sem  repetição  (isso  é,  se  um  mesmo  algoritmo  é  apresentado  em  mais  de  umresultado,  seu nome deve aparecer uma  única vez neste vetor).  Posições não preenchidasneste vetor devem conter o valornull.
* **getAlgoritmoMelhorResultado:**  deve receber como parâmetro o nome da medida a ser con-siderada  e  retornar  o  objeto  do  tipo  Algoritmo  que,  dentre  todos  os  resultados,  obteve  omaior valor daquela medida.  Caso a medida não tenha sido utilizada em nenhum resultado,deve retornar o valornull.
* **getAlgoritmoMelhorResultadoDataset:**  deve receber como parâmetros o nome do conjuntode dados e da medida a serem considerados.  Este método deve retornar o objeto do tipoAlgoritmo que, para a medida e conjunto de dados especificados, apresenta o maior valor.Caso a medida e o conjunto de dados não tenham sido utilizados em um mesmo resultado,deve retornarnull.
* **imprimeResumoExperimento:**  este método deve imprimir um resumo completo do experi-mento.  Deve mostrar, a data de realização dos experimentos e listar todos os detalhes dosresultados obtidos,  sendo,  para cada resultado:**  nome do algoritmo utilizado,  com os res-pectivos parâmetros;  nome do conjunto de dados utilizado, com seu número de exemplos,atributos  e  classes;  nome  e  valor  de  cada  medida  de  avaliação  obtida  pelo  algoritmo  noconjunto de dados
