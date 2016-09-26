<!DOCTYPE html>
<html ng-app="ImpostometroPessoalApp">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Impostômetro Pessoal</title>

<!-- Bootstrap -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/angular-material/1.1.0/angular-material.css" rel="stylesheet">

<!-- App CSS -->
<link href="resources/css/app.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body ng-controller="ImpostometroCalculoController" ng-cloak>


	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Impostômetro Pessoal</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Início</a></li>
					<li><a href="#">Opções</a></li>
					<li><a href="#">Perfil</a></li>
					<li><a href="#">Ajuda</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<div id="main" class="container-fluid">
		<h3 class="page-header">Início</h3>

		<form class="form-horizontal" ng-submit="calculaImpostos()">
			<!-- area de campos do form -->
				<fieldset>

					<!-- Form Name -->
					<legend>Seus Dados</legend>

					<div class="well well-sm">
						<strong><span class="glyphicon glyphicon-asterisk"></span>Campos obrigatórios</strong>
					</div>

					<!-- Multiple Radios -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="formaContratacao">Como você obtém sua renda mensal?</label>
						<div class="col-md-6" layout="column" ng-cloak>
						<div class="radio">
								<label for="formaContratacao-0"> <input type="radio" name="formaContratacao" id="formaContratacao-0" value="1"
									ng-model="formUsuarioValores.indTipoRenda" checked="checked"> Sou funcionário de empresa privada e regido pela CLT
								</label>
							</div>
							<div class="radio">
								<label for="formaContratacao-1"> <input type="radio" name="formaContratacao" id="formaContratacao-1" value="2" ng-model="formUsuarioValores.indTipoRenda"> Sou
									funcionário de empresa privada e emito nota através de uma Pessoa Jurídica
								</label>
							</div>
							<div class="radio">
								<label for="formaContratacao-2"> <input type="radio" name="formaContratacao" id="formaContratacao-2" value="3" ng-model="formUsuarioValores.indTipoRenda"> Sou
									funcionário público
								</label>
							</div>
							<div class="radio">
								<label for="formaContratacao-3"> <input type="radio" name="formaContratacao" id="formaContratacao-3" value="4" ng-model="formUsuarioValores.indTipoRenda"> Sou
									profissional liberal formalizado
								</label>
							</div>
							<div class="radio">
								<label for="formaContratacao-4"> <input type="radio" name="formaContratacao" id="formaContratacao-4" value="5" ng-model="formUsuarioValores.indTipoRenda"> Sou
									profissional liberal sem formalização
								</label>
							</div>
							<div class="radio">
								<label for="formaContratacao-5"> <input type="radio" name="formaContratacao" id="formaContratacao-5" value="6" ng-model="formUsuarioValores.indTipoRenda"> Sou
									aposentado
								</label>
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrRendaMensal">Qual é a sua renda mensal?</label>
						<div class="input-group col-md-2">
							<input id="vlrRendaMensal" name="usuarioValores.vlrRendaMensal" type="number" aria-label="amount" placeholder="Digite o valor total" class="form-control input-md priceFormat"
							  ng-model="formUsuarioValores.vlrRendaMensal" 	required>
							<div class="tool-tip slideIn bottom">Digite o valor total de todas as suas rendas</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrBeneficios">Qual é o valor dos seus benefícios?</label>
						<div class="input-group col-md-2">
							<input id="vlrBeneficios" name="usuarioValores.vlrBeneficios" type="number" aria-label="amount" placeholder="Digite o valor total" class="form-control input-md priceFormat"
								ng-model="formUsuarioValores.vlrBeneficios" required>
							<div class="tool-tip slideIn bottom">Digite o valor total dos seus benefícios como convênio médico, vale refeição, vale transporte, etc.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label" for="numDependentes">Quantos dependentes você possui?</label>
						<div class="input-group col-md-4 spinner">
							<input type="number" aria-label="amount" class="form-control"	value="0" class="form-control input-md priceFormat" id="numDependentes" name="usuarioValores.numDependentes" 
							    ng-model="formUsuarioValores.numDependentes" required>
							<div class="input-group-btn-vertical">
								<button class="btn btn-default" type="button">
									<i class="fa fa-caret-up"></i>
								</button>
								<button class="btn btn-default" type="button">
									<i class="fa fa-caret-down"></i>
								</button>
							</div>
							<div class="tool-tip slideIn bottom">Digite o número de dependentes</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrImoveis">Qual é o valor do(s) imóvel(is) próprio(s)?</label>
						<div class="input-group col-md-2">
							<input id="vlrImoveis" name="usuarioValores.vlrImoveis" type="number" aria-label="amount" placeholder="Digite o valor do seu aluguel mensal" class="form-control input-md priceFormat"
								ng-model="formUsuarioValores.vlrImoveis" required>
							<div class="tool-tip slideIn bottom">Digite o valor total do(s) seu(s) imóvel(is), incluindo IPTU e condomínio</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrFinanciamentoImoveis">Qual o valor mensal do financiamento do(s) seu(s) imóvel(is)?</label>
						<div class="input-group col-md-2">
							<input id="vlrFinanciamentoImoveis" name="usuarioValores.vlrFinanciamentoImoveis" type="number" aria-label="amount" placeholder="Caso seu(s) imóvel(is) estejam financiados, qual valor você paga mensalmente?" class="form-control input-md priceFormat"
								required> 
							<div class="tool-tip slideIn bottom">Caso seu(s) imóvel(is) esteja(m) financiado(s), digite o valor que você paga mensalmente</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrAluguel">Quanto você paga de aluguel mensalmente?</label>
						<div class="input-group col-md-2">
							<input id="vlrAluguel" name="usuarioValores.vlrAluguel" type="number" aria-label="amount" placeholder="Digite o valor do seu aluguel mensal" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor total do seu aluguel, incluindo IPTU e condomínio</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrVeiculos">Qual é o valor aproximado do(s) seu(s) veículo(s)?</label>
						<div class="input-group col-md-2">
							<input id="vlrVeiculos" name="usuarioValores.vlrVeiculos" type="number" aria-label="amount" placeholder="Digite o valor do(s) seu(s) veículos" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor do(s) seu(s) veículos</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrFinanciamentoVeiculos">Qual é o valor mensal do financiamento do(s) seu(s) veículo(s)?</label>
						<div class="input-group col-md-2">
							<input id="vlrFinanciamentoVeiculos" name="usuarioValores.vlrFinanciamentoVeiculos" type="number" aria-label="amount" placeholder="Digite o valor do(s) financiamento(s) do(s) seu(s) veículo(s)" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor do(s) financiamento(s) do(s) seu(s) veículo(s)</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrSupermercado">Qual é o valor mensal dos seus gastos com supermercado?</label>
						<div class="input-group col-md-2">
							<input id="vlrSupermercado" name="usuarioValores.vlrSupermercado" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com supermercados" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com supermercados, hortifruti, etc.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrConcessionarias">Qual é o valor mensal dos seus gastos com concessionárias?(água/luz/telefone/gás/tv)</label>
						<div class="input-group col-md-2">
							<input id="vlrConcessionarias" name="usuarioValores.vlrConcessionarias" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com água, luz, telefone, gás, internet, tv a cabo, etc." class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com água, luz, telefone, gás, internet, tv a cabo, etc.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrEducacao">Qual é o valor mensal dos seus gastos com educação?</label>
						<div class="input-group col-md-2">
							<input id="vlrEducacao" name="usuarioValores.vlrEducacao" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com educação" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com educação, tanto a sua quanto a dos seus dependentes.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrTransporte">Qual é o valor mensal dos seus gastos com transporte?</label>
						<div class="input-group col-md-2">
							<input id="vlrTransporte" name="usuarioValores.vlrTransporte" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com transporte" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com transporte como ônibus, metrô e combustível, tanto a sua quanto a dos seus dependentes.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrVestuario">Qual é o valor mensal dos seus gastos com vestuário?</label>
						<div class="input-group col-md-2">
							<input id="vlrVestuario" name="usuarioValores.vlrVestuario" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com vestuário" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com vestuário, tanto a sua quanto a dos seus dependentes.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrSaude">Qual é o valor mensal dos seus gastos com saúde?</label>
						<div class="input-group col-md-2">
							<input id="vlrSaude" name="usuarioValores.vlrSaude" type="number" aria-label="amount" placeholder="Digite o valor dos seus gastos com saúde" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus gastos com saúde, tanto a sua quanto a dos seus dependentes.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="vlrOutros">Qual é o valor mensal aproximado dos seus outros gastos?</label>
						<div class="input-group col-md-2">
							<input id="vlrOutros" name="usuarioValores.vlrOutros" type="number" aria-label="amount" placeholder="Digite o valor dos seus outros gastos" class="form-control input-md priceFormat"
								required>
							<div class="tool-tip slideIn bottom">Digite o valor dos seus outros gastos.</div>
							<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
						</div>
					</div>

					<!-- Button (Double) -->
					<div class="form-group">
						<button type="submit" class="btn btn-success btn-lg btn-block">
							<span class="glyphicon glyphicon-flash"></span> Calcular!
						</button>
					</div>

				</fieldset>

		</form>
	</div>

	<pre>
	    {{ resultadosCalculoImpostometro }}
	</pre>

	<!-- jQuery -->
	<script src="webjars/jquery/2.2.3/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<!-- App Core JavaScript -->
	<script type="text/javascript" src="webjars/angularjs/1.5.5/angular.min.js"></script>
	<script type="text/javascript" src="webjars/angularjs/1.5.5/angular-resource.min.js"></script>
	<script type="text/javascript" src="webjars/angularjs/1.5.5/angular-animate.min.js"></script>
 	<script type="text/javascript" src="webjars/angular-material/1.1.0/angular-material.min.js"></script> 
	<script type="text/javascript" src="webjars/bootstrap-material-design/0.5.9/js/material.js"></script>
	<script type="text/javascript" src="resources/js/setup.js"></script>
	<script type="text/javascript" src="resources/js/calculo-mvvc.js"></script>
</body>

</html>