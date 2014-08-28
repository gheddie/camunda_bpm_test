#---------------------------------------------------------------------------------------------------
#http://wiki.servicenow.com/index.php?title=Perl_Web_Services_Client_Examples
#---------------------------------------------------------------------------------------------------

#!/usr/bin/perl -w
 
# declare usage of SOAP::Lite
use SOAP::Lite;
 
# specifying this subroutine, causes basic auth to use
# its credentials when challenged
sub SOAP::Transport::HTTP::Client::get_basic_credentials {
   # login as the itil user
   return 'itil' => 'itil'; 
}
 
# declare the SOAP endpoint here
my $soap = SOAP::Lite
    -> proxy('http://bcc-ws65:8484/bpm-ejb-1.0-SNAPSHOT/HelloWorldWS?wsdl');
 
# calling the function
my $method = SOAP::Data->name('triggerWebserviceSimple')->attr({xmlns => 'http://wstest.logic.ejb.bpmtest.gravitex.de/'}); 

# create a new incident with the following short_description and category
my @params = ();
 
# invoke the SOAP call
#my $result = $soap->call($method => @params);
$soap->call($method => @params);
 
# print any SOAP faults that get returned
#print_fault($result);
# print the SOAP response that get return
#print_result($result);
 
# convenient subroutine for printing all results
sub print_result {
  my ($result) = @_;
 
  if ($result->body && $result->body->{'insertResponse'}) {
    my %keyHash = %{ $result->body->{'insertResponse'} };
    foreach my $k (keys %keyHash) {
        print "name=$k   value=$keyHash{$k}\n";
    }
  }
}
 
# convenient subroutine for printing all SOAP faults
sub print_fault {
  my ($result) = @_;
 
  if ($result->fault) {
    print "faultcode=" . $result->fault->{'faultcode'} . "\n";
    print "faultstring=" . $result->fault->{'faultstring'} . "\n";
  }
}