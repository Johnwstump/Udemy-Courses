
	var domain = {
		cats : new Map()
	}
	
	
	var controller = {	
		currCat: null,
		IMAGE_FOLDER : "Image",
		DEFAULT_TEXT_COLOR : "black",
		HIGHLIGHT_COLOR : "blue",
		
		init : function(){
			var catNames = ["Jim", "Sally", "Fluffy", "Benjamin", "Mint"];
			
			for (var i = 0; i < catNames.length; i++){
				listView.addNameToList(catNames[i]);
				domain.cats.set(catNames[i], {
					counter : 0,
					index: i
				});
			}
			
			catView.init();
			listView.init();
			if (catNames.length > 0){
				this.changeCat(catNames[0]);
			}
		},
	    
		changeCat : function(name){
			controller.saveCounterVal(catView.getCounterVal());
			this.currCat = domain.cats.get(name);

			listView.highlight(name);
			catView.setCounterVal(this.currCat.counter);
			catView.displayCatPic(this.IMAGE_FOLDER + "/cat" + (this.currCat.index + 1) + ".jpg");
			catView.displayCatName(name);
		},
		
		incrementCounter : function(){
			if (this.currCat != null){
				this.currCat.counter++;
				catView.setCounterVal(this.currCat.counter);
			}
		},
		
		saveCounterVal : function(val){
			if (this.currCat != null){
				this.currCat.counter = Number(val);
			}
		},
		
		setCurrCat : function(cat){
			this.currCat = cat;
		},
		
	}
	
	var listView = {
		currHighlight : "",
		
		init : function(){
			
		},
			
		addNameToList : function(name){
			var catListing = document.createElement('li');
			catListing.className = 'listedCats';
			catListing.id = name;
			catListing.textContent = name;
			
			catListing.addEventListener('click', (function(name){
				return function(){
					controller.changeCat(name);
				};
			})(name));
			
			document.getElementById('catList').append(catListing);
		},
		
		highlight : function(name){
			var highlight = document.getElementById(this.currHighlight);
			if (highlight != null){
				highlight.style.color = controller.DEFAULT_TEXT_COLOR;
			}
			
			highlight = document.getElementById(name);
			if (highlight != null){
				highlight.style.color = controller.HIGHLIGHT_COLOR;
			}
			
			this.currHighlight = name;
		}
		
	}
	
	var catView = {
		init : function(){
			document.getElementById('catPic').addEventListener('click', function(){
				controller.incrementCounter();
			});
		},
		
		displayCatName : function(name){
			document.getElementById('catName').textContent = name;
		},
		
		displayCatPic : function(src){
			document.getElementById('catPic').src = src;
		},
		
		getCounterVal : function(){
			return Number(document.getElementById('counter').textContent);
		},
		
		setCounterVal : function(val){
			document.getElementById('counter').textContent = val;
		}
	}

	controller.init();