import React, { useMemo, useState } from 'react';

function GrandiArrayComponent() {
  // definizione di un array di 1 milione di numeri casuali
  const [array, setArray] = useState(new Array(1000000).fill(0).map(() => Math.random()));

  // definizione di un memoized value "sum" che calcola la somma degli elementi dell'array
  const sum = useMemo(() => {
    console.log('Calcolo la somma degli elementi...');
    return array.reduce((acc, curr) => acc + curr, 0);
  }, [array]);

  // funzione chiamata al click del pulsante per ri-generare l'array
  function handleRegenerateArray() {
    setArray(new Array(1000000).fill(0).map(() => Math.random()));
  }

  return (
    <div>
      <p>Somma degli elementi dell'array: {sum}</p>
      <button onClick={handleRegenerateArray}>Genera nuovo array</button>
    </div>
  );
}

export default GrandiArrayComponent;