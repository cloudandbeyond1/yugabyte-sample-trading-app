truncate TABLE REF_DATA;

INSERT INTO REF_DATA(KEY_NAME, KEY_VALUE) VALUES ('trafficlocations',
'{"trafficlocations":[
 {
  "name":"Los Angeles",
  "country":"United States",
  "latitude":"34.052",
  "longitude": "-118.243"
 },
 {
  "name":"Washington",
  "country":"United States",
  "latitude":"47.751",
  "longitude": "-120.740"
 },
{
  "name":"London",
  "country":"United Kingdom",
  "latitude":"51.509",
  "longitude": "-0.118"
 },
{
  "name":"Mumbai",
  "country":"India",
  "latitude":"19.076",
  "longitude": "72.877"
 },
{
  "name":"Sydney",
  "country":"Australia",
  "latitude":"-33.865",
  "longitude": "151.209"
 }
]
}');

INSERT INTO REF_DATA(KEY_NAME, KEY_VALUE) VALUES( 'DBClustersTypes',
'{
	"DBClustersTypes": [{
			"title": "Single-region, multi-zone",
			"subtitle": "3 node deployed in US West"
		},
		{
			"title": " Multi-region, multi-zone with Read Replicas",
			"subtitle": "3 nodes deployed in US West, US Central and US East"
		},
		{
			"title": " Geo-partitioned",
			"subtitle": "5 nodes deployed in US West, South America East, Europe West, Asia South and Australia Southeast"
		}]
}'
);

INSERT INTO REF_DATA(KEY_NAME, KEY_VALUE) VALUES ('STOCK_SYMBOLS',
'{
"symbols": [{ "code":"AAPL" , "name":"Apple"},
{ "code":"MSFT" , "name":"Microsoft"},
{ "code":"GOOG" , "name":"Alphabet"},
{ "code":"GOOGL" , "name":"Alphabet"},
{ "code":"AMZN" , "name":"Amazon.com"},
{ "code":"TSLA" , "name":"Tesla"},
{ "code":"BRK.B" , "name":"Berkshire Hathaway"},
{ "code":"BRK.A" , "name":"Berkshire Hathaway"},
{ "code":"UNH" , "name":"UnitedHealth Group"},
{ "code":"JNJ" , "name":"Johnson & Johnson"},
{ "code":"XOM" , "name":"Exxon Mobil"},
{ "code":"V" , "name":"Visa Inc."},
{ "code":"WMT" , "name":"Walmart"},
{ "code":"JPM" , "name":"JPMorgan Chase & Co."},
{ "code":"META" , "name":"Meta Platforms"},
{ "code":"CVX" , "name":"Chevron"},
{ "code":"LLY" , "name":"Eli Lilly and Company"},
{ "code":"TSM" , "name":"Taiwan Semiconductor Manufacturing Company"},
{ "code":"NVDA" , "name":"NVIDIA"},
{ "code":"PG" , "name":"The Procter & Gamble Company"},
{ "code":"MA" , "name":"Mastercard"},
{ "code":"HD" , "name":"The Home Depot"},
{ "code":"BAC" , "name":"Bank of America"},
{ "code":"ABBV" , "name":"AbbVie"},
{ "code":"PFE" , "name":"Pfizer"},
{ "code":"KO" , "name":"The Coca-Cola Company"},
{ "code":"MRK" , "name":"Merck & Co."},
{ "code":"PEP" , "name":"PepsiCo"},
{ "code":"NVO" , "name":"Novo Nordisk"},
{ "code":"COST" , "name":"Costco Wholesale"},
{ "code":"TMO" , "name":"Thermo Fisher Scientific"},
{ "code":"ORCL" , "name":"Oracle"},
{ "code":"SHEL" , "name":"Shell"},
{ "code":"ASML" , "name":"ASML Holding"},
{ "code":"MCD" , "name":"McDonalds"},
{ "code":"DIS" , "name":"The Walt Disney Company"},
{ "code":"AVGO" , "name":"Broadcom"},
{ "code":"TM" , "name":"Toyota Motor"},
{ "code":"DHR" , "name":"Danaher"},
{ "code":"CSCO" , "name":"Cisco Systems"},
{ "code":"TMUS" , "name":"T-Mobile US"},
{ "code":"ACN" , "name":"Accenture"},
{ "code":"ABT" , "name":"Abbott Laboratories"},
{ "code":"WFC" , "name":"Wells Fargo & Company"},
{ "code":"AZN" , "name":"AstraZeneca"},
{ "code":"NVS" , "name":"Novartis AG"},
{ "code":"BABA" , "name":"Alibaba Group Holding"},
{ "code":"BHP" , "name":"BHP Group"},
{ "code":"CRM" , "name":"Salesforce.com"},
{ "code":"COP" , "name":"ConocoPhillips"},
{ "code":"BMY" , "name":"Bristol-Myers Squibb Company"},
{ "code":"FMX" , "name":"Fomento Economico Mexicano"},
{ "code":"VZ" , "name":"Verizon Communications"},
{ "code":"ADBE" , "name":"Adobe"},
{ "code":"TXN" , "name":"Texas Instruments"},
{ "code":"UPS" , "name":"United Parcel Service"},
{ "code":"NEE" , "name":"NextEra Energy"},
{ "code":"AMGN" , "name":"Amgen"},
{ "code":"LIN" , "name":"Linde"},
{ "code":"NKE" , "name":"Nike"},
{ "code":"CMCSA" , "name":"Comcast"},
{ "code":"PM" , "name":"Philip Morris International"},
{ "code":"TTE" , "name":"TotalEnergies SE"},
{ "code":"MS" , "name":"Morgan Stanley"},
{ "code":"SCHW" , "name":"The Charles Schwab Corporation"},
{ "code":"RTX" , "name":"Raytheon Technologies"},
{ "code":"QCOM" , "name":"Qualcomm"},
{ "code":"ELV" , "name":"Elevance Health"},
{ "code":"HON" , "name":"Honeywell International"},
{ "code":"NFLX" , "name":"Netflix"},
{ "code":"RY" , "name":"Royal Bank of Canada"},
{ "code":"T" , "name":"AT&T"},
{ "code":"CVS" , "name":"CVS Health"},
{ "code":"LMT" , "name":"Lockheed Martin"},
{ "code":"UNP" , "name":"Union Pacific"},
{ "code":"IBM" , "name":"International Business Machines"},
{ "code":"INTU" , "name":"Intuit"},
{ "code":"DE" , "name":"Deere & Company"},
{ "code":"LOW" , "name":"Lowes Companies"},
{ "code":"TD" , "name":"The Toronto-Dominion Bank"},
{ "code":"UL" , "name":"Unilever"},
{ "code":"HDB" , "name":"HDFC Bank"},
{ "code":"GS" , "name":"The Goldman Sachs Group"},
{ "code":"INTC" , "name":"Intel"},
{ "code":"MDT" , "name":"Medtronic plc."},
{ "code":"HSBC" , "name":"HSBC Holdings"},
{ "code":"EQNR" , "name":"Equinor ASA"},
{ "code":"SAP" , "name":"SAP SE"},
{ "code":"AXP" , "name":"American Express Company"},
{ "code":"BX" , "name":"Blackstone"},
{ "code":"SNY" , "name":"Sanofi"},
{ "code":"CAT" , "name":"Caterpillar"},
{ "code":"SPGI" , "name":"S&P Global"},
{ "code":"ADP" , "name":"Automatic Data Processing"},
{ "code":"BP" , "name":"BP plc"},
{ "code":"PYPL" , "name":"PayPal Holdings"},
{ "code":"SBUX" , "name":"Starbucks"},
{ "code":"PBR" , "name":"Petroleo Brasileiro"},
{ "code":"PBR.A" , "name":"Petroleo Brasileiro"},
{ "code":"AMD" , "name":"Advanced Micro Devices"}
]}
')
