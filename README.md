# algprogoo1-tb2
Segundo trabalho da disciplina de Algoritmos e Programação Orientada a Objetos 1 da UFMS. O trabalho visa o desenvolvimento de um sistema fictício de apoio a pesquisadores de Aprendizado de Máquina em java.

**Data de entrega:** 14/06/2019 às 23h55.

**Critérios de avaliação:** Completude do modelo (peso 4), corretude de funcionalidades (peso 5), classe de teste com todos os métodos sendo testados (peso 1).

---

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

Nesta abstra ̧c ̃ao, temos os seguintes atributos:
* nome:  vari ́avel textual que armazena o nome do algoritmo.
* parametros:   vetor  com  trˆes  posi ̧c ̃oes  de  vari ́aveis  em  ponto  flutuante  que  armazena  osparˆametros  do  algoritmo  utilizado.   Um  algoritmo  pode  ter  de  0  a  3  parˆametros.   Assim,nem todas as posi ̧c ̃oes do vetor poder ̃ao ser utilizadas.  Posi ̧c ̃oes n ̃ao utilizadas dever ̃ao serpreenchidas com o valor curingaF loat.M AXV ALU E.

Essa classe conta com os seguintes m ́etodos:
* M ́etodo construtor:  deve receber o nome e o conjunto de parˆametros do algoritmo, iniciali-zando, da maneira apropriada, as vari ́aveis de instˆancia.
* getNome:  deve retornar o nome do algoritmo.
* getParametros:  deve retornar o conjunto de parˆametros do algoritmo.

### MedidaAvaliacao
Neste classe, temos a abstra ̧c ̃ao de uma medida de avalia ̧c ̃ao que poder ́a ser utilizada pelos pes-quisadores para avaliar seus algoritmos. 

S ̃ao atributos desta classe:
* nome:  vari ́avel textual que armazena o nome da medida de avalia ̧c ̃ao.
* menorValor:   vari ́avel  em  ponto  flutuante  que  armazena  o  menor  valor  que  a  medida  deavalia ̧c ̃ao pode assumir.
* maiorValor:   vari ́avel  em  ponto  flutuante  que  armazena  o  maior  valor  que  a  medida  deavalia ̧c ̃ao pode assumir.

Al ́em disso, a classe tem os seguintes m ́etodos:
* Construtor:   deve  receber  como  parˆametros  o  nome  da  medida  de  avalia ̧c ̃ao,  seumenor valor e seu maior valor, respectivamente.  Deve inicializar, de maneira adequada, asvari ́aveis de instˆancia.
* getNome:  deve retornar o nome da medida de avalia ̧c ̃ao.
* getMenorValor:  deve retornar o menor valor que a medida de avalia ̧c ̃ao pode assumir.
* getMaiorValor:  deve retornar o maior valor que a medida de avalia ̧c ̃ao pode assumir.

### ValorAvaliacao
Classe respons ́avel por representar um valor de avalia ̧c ̃ao obtida por um algoritmo em uma deter-minada medida de avalia ̧c ̃ao.

S ̃ao seus atributos:
* valor:  vari ́avel de ponto flutuante que armazena o score obtido pelo algoritmo na medida deavalia ̧c ̃ao utilizada.
* medida:   vari ́avel  do  tipo  MedidaAvaliacao  que  armazena  a  medida  de  avalia ̧c ̃ao  à  qualpertence este valor obtido.

S ̃ao m ́etodos desta classe:
* M ́etodo construtor:  deve receber uma instˆancia da classe MedidaAvalia ̧c ̃ao, que representaa  medida  de  avalia ̧c ̃ao  à  qual  pertence  este  valor.   Deve,  tamb ́em,  inicializar,  de  maneiraadequada, as vari ́aveis de instˆancia.
* setValor:  m ́etodo respons ́avel por armazenar o valor obtido pelo algoritmo na medida deavalia ̧c ̃ao.  Deve receber como parˆametro o valor da medida.  Este valor deve ser validado,de  acordo  com  os  limites  aceitos  pela  medida  utilizada.   Caso  o  valor  seja  aceito,  deve-se  guard ́a-lo  na  vari ́avel  de  instˆancia  correspondente  e  retornar  o  valortrue,  assinalandoque a atribui ̧c ̃ao foi bem sucedida.  Caso contr ́ario, deve imprimir uma mensagem na telainformando da impossibilidade de atribui ̧c ̃ao e retornar o valorfalse.
* getMedida:  deve retornar a medida de avalia ̧c ̃ao utilizada.
* getValor:  deve retornar o valor da medida de avalia ̧c ̃ao armazenada no objeto.

###  Dataset
Esta classe fornece uma abstra ̧c ̃ao de um conjunto de dados utilizado no experimento.  

Contem osseguintes atributos:
* numExemplos:  vari ́avel inteira que armazena o n ́umero de exemplos contidos no conjuntode dados.
* numAtributos:  vari ́avel inteira que armazena o n ́umero de atributos contidos no conjuntode dados.
* numClasses:  vari ́avel  inteira  que  armazena  o  n ́umero  de  classes  contidas  no  conjunto  dedados.
* nome:  vari ́avel textual que armazena o nome do conjunto de dados.

S ̃ao m ́etodos desta classe:
* M ́etodo  construtor:  deve  receber  como  parˆametros  o  n ́umero  de  exemplos,  o  n ́umero  deatributos,  o  n ́umero  de  classes  e  o  nome  do  conjunto  de  dados,  inicializando,  de  maneiraadequada, as vari ́aveis de instˆancia.
* getNumExemplos:  deve retornar o n ́umero de exemplos do conjunto de dados.
* getNumAtributos:  deve retornar o n ́umero de atributos do conjunto de dados.
* getNumClasses:  deve retornar o n ́umero de classes do conjunto de dados.
* getNome:  deve retornar o nome do conjunto de dados.

### Resultado
Esta  classe  fornece  uma  abstra ̧c ̃ao  de  um  resultado  obtido  nos  experimentos  realizados  de  umalgoritmo em um conjunto de dados, de acordo com algumas medidas de avalia ̧c ̃ao.

S ̃ao atributosdesta classe:
* algoritmo:  vari ́avel do tipo Algoritmo que armazena o algoritmo e suas configura ̧c ̃oes queforam utilizadas para obten ̧c ̃ao deste resultado.
* dataset:  vari ́avel do tipo Dataset que armazena o conjunto de dados utilizado na obten ̧c ̃aodeste resultado.
* avaliacao:  vetor de trˆes posi ̧c ̃oes do tipo ValorAvaliacao que armazenam os valores de ava-lia ̧c ̃ao  obtidas  pelo  algoritmo  no  conjunto  de  dados,  de  acordo  com  at ́e  trˆes  medidas  deavalia ̧c ̃ao.  Um algoritmo pode ser avaliado utilizando de 1 a 3 medidas de avalia ̧c ̃ao.  Assim,nem todas as posi ̧c ̃oes do vetor estar ̃ao preenchidas.  Posi ̧c ̃oes vazias devem conter o valornull.

S ̃ao m ́etodos desta classe:
* M ́etodo construtor:  deve receber como parˆametros o algoritmo e o conjunto de dados uti-lizado  na  obten ̧c ̃ao  deste  resultado.   Deve  inicializar  as  vari ́aveis  de  instˆancia  da  maneiraadequada.
* getAlgoritmo:  deve retornar o algoritmo utilizado neste resultado. 
* getDataset:  deve retornar o conjunto de dados utilizado neste resultado.
* getNomeDoAlgoritmo:  deve retornar o nome do algoritmo utilizado neste resultado.
* getNomeDoDataset:  deve retornar o nome do conjunto de dados utilizado neste resultado.
* addAvaliacao:  m ́etodo utilizado para adicionar um resultado de avalia ̧c ̃ao do algoritmo noconjunto de dados.  Uma avalia ̧c ̃ao s ́o poder ́a ser adicionada se houver espa ̧co no vetor deavalia ̧c ̃oes.  Al ́em disso, s ́o  ́e poss ́ıvel haver uma avalia ̧c ̃ao para cada medida de avalia ̧c ̃ao.Assim, n ̃ao  ́e poss ́ıvel haver no vetor de avalia ̧c ̃oes duas ou mais avalia ̧c ̃oes que utilizem amesma medida de avalia ̧c ̃ao.  Este m ́etodo deve retornartruecaso a adi ̧c ̃ao de uma avalia ̧c ̃aoseja bem sucedida.  Caso a adi ̧c ̃ao de uma avalia ̧c ̃ao n ̃ao seja poss ́ıvel, deve imprimir umamensagem na tela informando da impossibilidade e retornar o valorfalse.
* getAvaliacoes:  deve retornar o vetor de avalia ̧c ̃oes obtidas neste resultado.
* getAvaliacaoPorMedida:  deve receber como parˆametro o nome da medida de avalia ̧c ̃ao quese  deseja  obter  o  valor.   Caso  a  medida  n ̃ao  seja  encontrada  no  vetor  de  avalia ̧c ̃oes,  estem ́etodo deve retornarnull.  Caso a medida seja encontrada, seu objeto correspondente dotipoValorAvaliacaodeve ser retornado.

### Experimento
Esta  ́e a classe que armazena todos os dados dos experimentos e que permite ao pesquisador aobten ̧c ̃ao de algumas informa ̧c ̃oes sobre o experimento.

S ̃ao atributos desta classe:
* dia:  vari ́avel inteira que armazena o dia de realiza ̧c ̃ao do experimento.
* mes:  vari ́avel inteira que armazena o mˆes de realiza ̧c ̃ao do experimento.
* ano:  vari ́avel inteira que armazena o ano de realiza ̧c ̃ao do experimento.
* resultados:  vetor de 10 posi ̧c ̃oes do tipo Resultado que armazena os resultados obtidos poralgoritmos em conjuntos de dados.  Um experimento pode ter de 1 a 10 resultados.  Assim,caso uma posi ̧c ̃ao n ̃ao seja preenchida, ela deve assumir valornull.

S ̃ao m ́etodos desta classe:
* M ́etodo construtor:  deve receber como parˆametros o dia,  o mˆes e o ano do experimento.Deve inicializar as vari ́aveis de instˆancia de maneira adequada.
* addResultado: m ́etodo utilizado para adi ̧c ̃ao de um resultado no experimento.  Um resultados ́o pode ser adicionado se n ̃ao exceder o m ́aximo de 10 resultados.  Al ́em disso, n ̃ao  ́e poss ́ıvelhaver repeti ̧c ̃ao de resultados.  Desta forma, seu vetor de resultados n ̃ao deve conter duasvezes resultados do mesmo algoritmo, com os mesmos parˆametros, no mesmo conjunto dedados.  Caso um resultado seja adicionado com sucesso, este m ́etodo deve retornar o valortrue.  Caso o resultado n ̃ao seja adicionado, deve-se imprimir uma mensagem informativa natela e retornar o valorfalse.
* getValoresResultados:  deve receber como parˆametro o nome da medida que deseja-se sabero valor nos diferentes resultados.  Este m ́etodo retorna um vetor de 10 posi ̧c ̃oes, contendoo  valor  da  medida  de  avalia ̧c ̃ao  nos  (at ́e)  10  resultados.   Caso  a  medida  n ̃ao  tenha  sidoutilizada em um determinado resultado, deve-se preencher a posi ̧c ̃ao correspondente no vetorde resposta com o valor curingaF loat.M AXV ALU E.
* getMediaResultados:  deve receber como parˆametro o nome da medida que deseja-se saber am ́edia ao longo dos diferentes resultados.  A m ́edia deve ser calculada considerando o n ́umerode resultados v ́alidos contidos no conjunto de resultados (ou seja, considerando o n ́umerode resultados que, de fato, utilizaram aquela medida de avalia ̧c ̃ao).  Deve retornar um valorem ponto flutuante contendo a m ́edia.  Caso a medida n ̃ao tenha sido utilizada em nenhumresultado, deve retornar o valor curingaF loat.M AXV ALU E.
* getMediaResultadosPorAlgoritmo:  similar ao m ́etodo anterior, deseja-se saber a m ́edia deuma  medida  obtida  por  um  algoritmo  ao  longo  dos  diferentes  resultados.   Deve  recebercomo parˆametros o nome do algoritmo e o nome da medida a serem pesquisadas.  A m ́ediadeve  ser  calculada  considerando  o  n ́umero  de  resultados  v ́alidos  contidos  no  conjunto  deresultados (ou seja, considerando o n ́umero de resultados para o algoritmo pesquisado que,de fato, utilizaram aquela medida de avalia ̧c ̃ao).  Deve retornar um valor em ponto flutuantecontendo a m ́edia.  Caso a medida ou o algoritmo n ̃ao tenham sido utilizados em nenhumresultado, deve retornar o valor curingaF loat.M AXV ALU E.
* getMediaResultadosPorDataset: tamb ́em similar ao m ́etodo anterior, deseja-se saber a m ́ediade uma medida obtida por qualquer algoritmo ao longo dos diferentes resultados que utiliza-ram um determinado conjunto de dados.  Deve receber como parˆametros o nome do conjuntode dados e o nome da medida a serem pesquisadas.  A m ́edia deve ser calculada considerandoo n ́umero de resultados v ́alidos contidos no conjunto de resultados (ou seja, considerando on ́umero de resultados que, de fato, utilizaram aquela medida de avalia ̧c ̃ao naquele conjuntode dados).  Deve retornar um valor em ponto flutuante contendo a m ́edia.  Caso a medida ouo algoritmo n ̃ao tenham sido utilizados em nenhum resultado, deve retornar o valor curingaF loat.M AXV ALU E.
* getMelhorResultado:  deve receber como parˆametro do nome da medida a ser pesquisada eretornar o objeto do tipo Resultado que apresenta o maior valor para a medida pesquisada.Caso a medida n ̃ao tenha sido utilizada, deve-se retornar o valornull.
* getMelhorResultadoPorAlgoritmo:  deve  receber  como  parˆametros  o  nome  da  medida  e  onome  do  algoritmo  a  serem  pesquisados.   Deve  retornar  o  objeto  do  tipo  Resultado  queapresenta o maior valor para a medida pesquisada apresentado pelo algoritmo especificado.Caso  a  medida  e  o  algoritmo  n ̃ao  tenham  sido  utilizados  em  um  mesmo  resultado,  deveretornar o valornull.
* getMelhorResultadoPorDataset:  similar ao anterior, deve receber como parˆametros o nomeda  medida  e  o  nome  do  conjunto  de  dados  a  serem  pesquisados.   Deve  retornar  o  objetodo tipo Resultado que apresenta o maior valor para a medida pesquisada apresentado porqualquer algoritmo no conjunto de dados especificado.  Caso a medida e o conjunto de dadosn ̃ao tenham sido utilizados em um mesmo resultado, deve retornar o valornull.
* getPiorResultado:  deve  receber  como  parˆametro  do  nome  da  medida  a  ser  pesquisada  eretornar o objeto do tipo Resultado que apresenta o menor valor para a medida pesquisada.Caso a medida n ̃ao tenha sido utilizada, deve-se retornar o valornull.
* getPiorResultadoPorAlgoritmo:  deve receber como parˆametros o nome da medida e o nomedo algoritmo a serem pesquisados.  Deve retornar o objeto do tipo Resultado que apresentao menor valor para a medida pesquisada apresentado pelo algoritmo especificado.  Caso amedida e o algoritmo n ̃ao tenham sido utilizados em um mesmo resultado, deve retornar ovalornull.
* getPiorResultadoPorDataset:  similar ao anterior, deve receber como parˆametros o nome damedida e o nome do conjunto de dados a serem pesquisados.  Deve retornar o objeto do tipoResultado que apresenta o menor valor para a medida pesquisada apresentado por qualqueralgoritmo  no  conjunto  de  dados  especificado.   Caso  a  medida  e  o  conjunto  de  dados  n ̃aotenham sido utilizados em um mesmo resultado, deve retornar o valornull.
* getDatasetMelhorResultado:  deve receber como parˆametro o nome da medida a ser consi-derada e retornar,  dentre todos os resultados apresentados,  o objeto do tipo Dataset querepresenta o conjunto de dados que obteve o maior valor da medida especificada.  Caso amedida n ̃ao tenha sido utilizada em nenhum resultado, deve retornarnull.
* getDatasetMelhorResultadoAlgoritmo:  deve receber como parˆametros os nomes da medidae do algoritmo a serem considerados.  Este m ́etodo deve retornar um objeto do tipo Datasetque representa o conjunto de dados no qual o algoritmo especificado apresentou o maior valorda medida especificada.  Caso a medida e o algoritmo n ̃ao tenham sido utilizados juntos emnenhum resultado, deve retornarnull.
* getNomesAlgoritmosUtilizados:  deve  retornar  um  vetor  contendo  o  nome  dos  algoritmosutilizados,  sem  repeti ̧c ̃ao  (isso   ́e,  se  um  mesmo  algoritmo   ́e  apresentado  em  mais  de  umresultado,  seu nome deve aparecer uma   ́unica vez neste vetor).  Posi ̧c ̃oes n ̃ao preenchidasneste vetor devem conter o valornull.
* getAlgoritmoMelhorResultado:  deve receber como parˆametro o nome da medida a ser con-siderada  e  retornar  o  objeto  do  tipo  Algoritmo  que,  dentre  todos  os  resultados,  obteve  omaior valor daquela medida.  Caso a medida n ̃ao tenha sido utilizada em nenhum resultado,deve retornar o valornull.
* getAlgoritmoMelhorResultadoDataset:  deve receber como parˆametros o nome do conjuntode dados e da medida a serem considerados.  Este m ́etodo deve retornar o objeto do tipoAlgoritmo que, para a medida e conjunto de dados especificados, apresenta o maior valor.Caso a medida e o conjunto de dados n ̃ao tenham sido utilizados em um mesmo resultado,deve retornarnull.
* imprimeResumoExperimento:  este m ́etodo deve imprimir um resumo completo do experi-mento.  Deve mostrar, a data de realiza ̧c ̃ao dos experimentos e listar todos os detalhes dosresultados obtidos,  sendo,  para cada resultado:  nome do algoritmo utilizado,  com os res-pectivos parˆametros;  nome do conjunto de dados utilizado, com seu n ́umero de exemplos,atributos  e  classes;  nome  e  valor  de  cada  medida  de  avalia ̧c ̃ao  obtida  pelo  algoritmo  noconjunto de dados
