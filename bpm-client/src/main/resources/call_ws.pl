my $componentId = "test_vb";
my $componentState = "CLOSED";
system("java de.gravitex.bpmtest.PerlWebServiceConnector -componentId $componentId -componentState $componentState")