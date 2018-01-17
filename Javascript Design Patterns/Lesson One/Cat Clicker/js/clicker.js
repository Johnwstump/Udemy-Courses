
	var domain = {
		CAT_NAMES : ["Jim", "Sally", "Fluffy", "Benjamin", "Mint"],
		cats : new Map(),
		currCat : null
	}
	
	
	var controller = {	
		IMAGE_FOLDER : "Image",


		
		init : function(){
			for (var i = 0; i < domain.CAT_NAMES.length; i++){
				listView.addNameToList(domain.CAT_NAMES[i]);
				domain.cats.set(domain.CAT_NAMES[i], {
					counter : 0,
					index: i
				});
			}
			
			catView.init();
			listView.init();
			if (domain.CAT_NAMES.length > 0){
				this.changeCat(domain.CAT_NAMES[0]);
			}
		},
	    
		changeCat : function(name){
			domain.currCat = domain.cats.get(name);

			listView.highlight(name);
			catView.setCounterVal(domain.currCat.counter);
			catView.displayCatPic(this.IMAGE_FOLDER + "/cat" + (domain.currCat.index + 1) + ".jpg");
			catView.displayCatName(name);
		},
		
		incrementCounter : function(){
			if (domain.currCat != null){
				domain.currCat.counter++;
				catView.setCounterVal(domain.currCat.counter);
			}
		},
		
		setCurrCat : function(cat){
			domain.currCat = cat;
		}
		
	}
	
	var listView = {
		DEFAULT_TEXT_COLOR : "black",
		HIGHLIGHT_COLOR : "blue",
		currHighlight : "",
		catList : null,
		
		init : function(){
			this.catList = document.getElementById('catList');
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
			
			catList.append(catListing);
		},
		
		highlight : function(name){
			var highlight = document.getElementById(this.currHighlight);
			if (highlight != null){
				highlight.style.color = this.DEFAULT_TEXT_COLOR;
			}
			
			highlight = document.getElementById(name);
			if (highlight != null){
				highlight.style.color = this.HIGHLIGHT_COLOR;
			}
			
			this.currHighlight = name;
		}
		
	}
	
	var catView = {
		catPic : null,
		catName : null,
		counter : null,
		init : function(){
			this.catPic = document.getElementById('catPic');
			this.catName = document.getElementById('catName');
			this.counter = document.getElementById('counter');
			catPic.addEventListener('click', function(){
				controller.incrementCounter();
			});
		},
		
		displayCatName : function(name){
			catName.textContent = name;
		},
		
		displayCatPic : function(src){
			catPic.src = src;
		},
		
		getCounterVal : function(){
			return Number(counter.textContent);
		},
		
		setCounterVal : function(val){
			counter.textContent = val;
		}
	}

	controller.init();