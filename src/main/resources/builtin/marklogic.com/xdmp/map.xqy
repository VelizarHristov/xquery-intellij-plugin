xquery version "1.0-ml";
(:~
 : MarkLogic map functions
 :
 : @see https://docs.marklogic.com/map
 :)
module namespace map = "http://marklogic.com/xdmp/map";

import module namespace a = "http://reecedunn.co.uk/xquery/annotations" at "res://reecedunn.co.uk/xquery/annotations.xqy";

declare %a:since("marklogic", "5.0") function map:clear($map as map:map) as empty-sequence() external;
declare %a:since("marklogic", "6.0") function map:contains($map as map:map, $key as xs:string) as xs:boolean external;
declare %a:since("marklogic", "5.0") function map:count($map as map:map) as xs:unsignedInt external;
declare %a:since("marklogic", "5.0") function map:delete($map as map:map, $key as xs:string) as empty-sequence() external;
declare %a:since("marklogic", "7.0") function map:entry($key as xs:string, $value as item()*) as map:map external;
declare %a:since("marklogic", "5.0") function map:get($map as map:map, $key as xs:string) as item()* external;
declare %a:since("marklogic", "5.0") function map:keys($map as map:map) as xs:string* external;
declare %a:since("marklogic", "5.0") function map:map() as map:map external;
declare %a:since("marklogic", "5.0") function map:map($map as element(map:map)) as map:map external;
declare %a:since("marklogic", "7.0") function map:new() as map:map external;
declare %a:since("marklogic", "7.0") function map:new($map as element(map:map)) as map:map external;
declare %a:since("marklogic", "5.0") function map:put($map as map:map, $key as xs:string, $value as item()*) as empty-sequence() external;
declare %a:since("marklogic", "9.0") function map:set-javascript-by-ref($map as map:map, $key as xs:boolean) as empty-sequence() external;
declare %a:since("marklogic", "9.0") function map:with($map as map:map, $key as xs:string, $value as item()*) as map:map external;