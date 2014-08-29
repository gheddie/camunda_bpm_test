my $javaArgs = " -cp C:\fhem_lib\bpm-client-1.0-SNAPSHOT.jar;C:\fhem_lib\cxf-bundle-2.7.12.jar;C:\fhem_lib\spring-core-3.1.0.RELEASE.jar;C:\fhem_lib\xmlschema-core-2.1.0.jar;C:\fhem_lib\wsdl4j-1.6.3.jar;C:\fhem_lib\bpm-ejb-1.0-SNAPSHOT.jar;C:\fhem_lib\neethi-3.0.3.jar;C:\fhem_lib\asm-3.3.1.jar;C:\fhem_lib\commons-cli-1.2.jar -Xmx256";
my $className = "de.gravitex.bpmtest.PerlWebServiceConnector";
my $javaCmd = "java ".$JAVA_ARGS." "$className." ".join(' ', @ARGV);
system("$javaCmd");