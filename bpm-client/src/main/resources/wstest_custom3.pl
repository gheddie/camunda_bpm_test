use SOAP::Lite;
my $lite = SOAP::Lite -> service('http://localhost:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl');
$lite->triggerWebserviceSimple();