let counter = 0;

        function increment() {
            counter++;
            document.getElementById('counterValue').textContent = counter;
        }

        function decrement() {
            if (counter > 0) {
                counter--;
                document.getElementById('counterValue').textContent = counter;
            }
        }
        function increment3() {
            counter++;
            document.getElementById('counterValue3').textContent = counter;
        }

        function decrement3() {
            if (counter > 0) {
                counter--;
                document.getElementById('counterValue3').textContent = counter;
            }
        }