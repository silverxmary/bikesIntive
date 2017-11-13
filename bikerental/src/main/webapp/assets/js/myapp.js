$('select').on('change', function() {
	//alert(event.target.id);
  //alert( this.value );
	var res = event.target.id;
	var index = res.split("-");
	var idfrec= "#timefrec-"+index[1];
  if(this.value=='1'){
	  $(idfrec).text("hours");
  }
  if(this.value=='2'){
	  $(idfrec).text("days");
  }
  if(this.value=='3'){
	  $(idfrec).text("weeks");
  }
  if(this.value=='0'){
	  $(idfrec).text("");
  }
})