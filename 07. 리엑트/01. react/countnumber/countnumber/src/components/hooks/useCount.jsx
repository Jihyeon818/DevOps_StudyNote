import { useState } from "react";

const useCount = (val) => {
  const [number, setNumber] = useState(val);

  const changeNumber = (val) => {
    setNumber((num) => num + val);
  };

  return [number, changeNumber];
};

export default useCount;
