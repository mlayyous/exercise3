import React from 'react';

function Currency({ value, currency }: { value: number, currency: string }) {
  const formatted = format(value);
  return <span>{currency}{formatted}</span>;
}

const format = (toFormat: number) =>
  toFormat
    .toFixed(2)
    .replace(/\d(?=(\d{3})+\.)/g, '$&,');

export default Currency;

