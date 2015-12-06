
// usage: log('inside coolFunc', this, arguments);
window.log = function(){
  log.history = log.history || [];   // store logs to an array for reference
  log.history.push(arguments);
  if(this.console) {
      arguments.callee = arguments.callee.caller;
      console.log( Array.prototype.slice.call(arguments) );
  }
};
(function(b){function c(){}for(var d="assert,count,debug,dir,dirxml,error,exception,group,groupCollapsed,groupEnd,info,log,markTimeline,profile,profileEnd,time,timeEnd,trace,warn".split(","),a;a=d.pop();)b[a]=b[a]||c})(window.console=window.console||{});



/* 
    Plugin to make variable height divs equal heights 
    Thanks to Adham Dannaway, via:
    http://www.cre8ivecommando.com/equal-height-columns-using-jquery-6164/
*/

$.fn.sameHeights = function() {

    $(this).each(function(){
    var tallest = 0;

    $(this).children().each(function(i){
        if (tallest < $(this).height()) { tallest = $(this).height(); }
    });
    $(this).children().css({'height': tallest});
});

return this;
};